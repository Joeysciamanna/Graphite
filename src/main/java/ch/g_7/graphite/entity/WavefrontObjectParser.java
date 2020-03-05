package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.material.Material;
import ch.g_7.graphite.base.material.MaterialKey;
import ch.g_7.graphite.base.material.WavefrontMaterialProducer;
import ch.g_7.graphite.base.material.WavefrontMaterialProvider;
import ch.g_7.graphite.math.vec2.Vector2f;
import ch.g_7.graphite.math.vec3.Vector3f;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.util.helper.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class WavefrontObjectParser {

    private List<Vector3f> positions = new ArrayList<>();
    private List<Vector2f> textureCoords = new ArrayList<>();
    private List<Vector3f> normals = new ArrayList<>();
    private List<Face> faces = new ArrayList<>();
    
    private InputStream inputStream;
    private Entity entity = new EmptyEntity();
    private String name;
    
    public WavefrontObjectParser(InputStream inputStream) {
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
   
    }
    

    private static class Face {
        Vector3f posIndices = new Vector3f();
        Vector3f textIndices = new Vector3f();
        Vector3f normalIndices = new Vector3f();

        Material material;
        
        public Face(String i1, String i2, String i3, Material material) {
            parseIndexGroup(i1, Vector3f::setX);
            parseIndexGroup(i2, Vector3f::setY);
            parseIndexGroup(i3, Vector3f::setZ);
            this.material = material;
        }

        private void parseIndexGroup(String indexGroup, BiConsumer<Vector3f, Float> setter) {
            String[] tokens = indexGroup.split("/");
            setter.accept(posIndices, Float.parseFloat(tokens[0]) - 1);
            if(!tokens[1].isBlank())
                setter.accept(textIndices, Float.parseFloat(tokens[1]) - 1);
            else
                textIndices = null;
            setter.accept(normalIndices, Float.parseFloat(tokens[2]) - 1);
        }

        public Material getMaterial() {
			return material;
		}
    }

}

