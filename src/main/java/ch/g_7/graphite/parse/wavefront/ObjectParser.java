package ch.g_7.graphite.parse.wavefront;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.material.Material;
import ch.g_7.graphite.base.material.MaterialKey;
import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.vao.IVBOType;
import ch.g_7.graphite.entity.EmptyEntity;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.math.vec2.Vector2f;
import ch.g_7.graphite.math.vec3.Vector3f;
import ch.g_7.graphite.resource.ResourceManager;

public class ObjectParser {

    private List<Vector3f> positions = new ArrayList<>();
    private List<Vector2f> textureCoords = new ArrayList<>();
    private List<Vector3f> normals = new ArrayList<>();
    private List<Face> faces = new ArrayList<>();
    
    private InputStream inputStream;
    private Entity entity = new EmptyEntity();
    private String name;
    
    public ObjectParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    public void parse(){
        readTokens();
    }

    
    private void readTokens() {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    	Material material = null;
        try {
            while(reader.ready()) {
                String line = reader.readLine();
                if (line.startsWith("#")) continue;

                String[] values = line.split("\\s+");

                switch (values[0]){
                    case "o":
                        name = values[1];
                        break;
                    case "v":
                        positions.add(new Vector3f(
                                Float.valueOf(values[1]),
                                Float.valueOf(values[2]),
                                Float.valueOf(values[3])
                        ));
                        break;
                    case "vt":
                        textureCoords.add(new Vector2f(
                                Float.valueOf(values[1]),
                                Float.valueOf(values[2])
                        ));
                        break;
                    case "vn":
                        normals.add(new Vector3f(
                                Float.valueOf(values[1]),
                                Float.valueOf(values[2]),
                                Float.valueOf(values[3])
                        ));
                        break;
                    case "f":
                        faces.add(new Face(values[1], values[2], values[3], material));
                    case "usemtl":
                    	material = ResourceManager.getActive().allocate(new MaterialKey(values[1]), null);
                    default:
                        break;
                }
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    
    private void parseEntity() {
    	int[] indices = new int[this.faces.size()];
    	float[] positions = new float[this.positions.size() * 3];
    	float[] textureCoords = new float[this.textureCoords.size() * 2];
    	float[] normals = new float[this.normals.size() * 3];

    	int i = 0;
        for (Vector3f pos : this.positions) {
        	positions[i * 3] = pos.x;
        	positions[i * 3 + 1] = pos.y;
        	positions[i * 3 + 2] = pos.z;
            i++;
        }
        
        i = 0;
        for (Face face : faces) {
			for (IndexGroup group : face.indexGroups) {
				int posIndex = group.position;
				indices[i++] = posIndex;
				
				if (group.textCoord >= 0) {
			        Vector2f textCoord = this.textureCoords.get(group.textCoord);
			        textureCoords[posIndex * 2] = textCoord.x;
			        textureCoords[posIndex * 2 + 1] = 1 - textCoord.y;
			    }
			    if (group.normal >= 0) {
			        // Reorder vectornormals
			        Vector3f vecNorm = this.normals.get(group.normal);
			        normals[posIndex * 3] = vecNorm.x;
			        normals[posIndex * 3 + 1] = vecNorm.y;
			        normals[posIndex * 3 + 2] = vecNorm.z;
			    }
			}
		}
        
        Mesh mesh = new Mesh(positions, indices, new IVBOType[] {});
   
  
    }
    

    private static class Face {
        
    	private IndexGroup[] indexGroups = new IndexGroup[3];
        private Material material;
        
        public Face(String i1, String i2, String i3, Material material) {
            parseIndexGroup(i1, 0);
            parseIndexGroup(i2, 1);
            parseIndexGroup(i3, 2);
            this.material = material;
        }

        private void parseIndexGroup(String indexGroup, int storeIndex) {
	       String[] tokens = indexGroup.split("/");
	       indexGroups[storeIndex] = new IndexGroup(Integer.valueOf(tokens[0]) - 1,
	    		   									Integer.valueOf(tokens[1].isBlank() ? "0" : tokens[1]) - 1,
	    		   									Integer.valueOf(tokens[2].isBlank() ? "0" : tokens[2]) - 1);
        }

    }
    
    
    private static class IndexGroup{
    	private int position, textCoord, normal;

		public IndexGroup(int position, int textCoord, int normal) {
			this.position = position;
			this.textCoord = textCoord;
			this.normal = normal;
		}
    	
    }

}

