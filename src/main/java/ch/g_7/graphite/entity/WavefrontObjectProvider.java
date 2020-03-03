package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.material.Material;
import ch.g_7.graphite.base.material.MaterialKey;
import ch.g_7.graphite.math.vec2.Vector2f;
import ch.g_7.graphite.math.vec3.Vector3f;
import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.util.io.IFileLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WavefrontObjectProvider extends BasicResourceProvider<Entity, EntityKey> {


    @Override
    protected Entity loadResource(EntityKey resourceKey, IFileLoader fileLoader) throws IllegalArgumentException {
        InputStream stream = fileLoader.loadFile(resourceKey.getName());
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        try {
            EmptyEntity rootEntity = new EmptyEntity();

            String name;
            Material material;

            List<Vector3f> positions = new ArrayList<>();
            List<Vector2f> textureCoords = new ArrayList<>();
            List<Vector3f> normals = new ArrayList<>();

            while(reader.ready()) {
                String line = reader.readLine();
                if (line.startsWith("#")) continue;

                String[] values = line.split("\\s+");
                if(values[0].equals("mtllib")){
                    ResourceManager.getActive().allocate(new MaterialKey(values[1]), fileLoader);
                }else if(values[0].equals("o")){
                    name = values[1];
                }else if(values[0].equals("v")){
                    positions.add(new Vector3f(
                            Float.valueOf(values[1]),
                            Float.valueOf(values[2]),
                            Float.valueOf(values[3])
                    ));
                }else if(values[0].equals("vt")){
                    textureCoords.add(new Vector2f(
                            Float.valueOf(values[1]),
                            Float.valueOf(values[2])
                    ));
                }else if(values[0].equals("vn")){
                    normals.add(new Vector3f(
                            Float.valueOf(values[1]),
                            Float.valueOf(values[2]),
                            Float.valueOf(values[3])
                    ));
                }else if(values[0].equals("usemtl")){
                    material =  ResourceManager.getActive().allocate(new MaterialKey(resourceKey.getName() + ":" + values[1]), fileLoader);
                }

            }




        } catch (IOException e){
           throw new RuntimeException(e);
        }



        return null;
    }



    @Override
    public boolean canProvide(IResourceKey resourceKey) {
        return containsResourceNames(resourceKey, EntityKey.NAME);
    }

    @Override
    public IResourceProvider<Entity, EntityKey> newInstance() {
        return new WavefrontObjectProvider();
    }
}
