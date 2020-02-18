package ch.g_7.graphite.base.material;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IFileLoader;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.graphite.util.Color;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class MaterialProducer extends BasicResourceProvider<Material, MaterialKey> {

    private IFileLoader fileLoader;

    public MaterialProducer(IFileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }


    @Override
    protected Material loadResource(MaterialKey resourceKey) throws IllegalArgumentException {
        String content = readFile(resourceKey.getName());
        JSONObject jsonObject = new JSONObject(content);
        Material material = parseMaterial(jsonObject);
        return material;
    }


    private String readFile(String path) {
        String content;
        try {
            File file = fileLoader.loadFile(path);
            content = Files.readString(file.toPath());
        } catch (IOException e) {
            throw new IllegalArgumentException("Material file not found", e);
        }
        return content;
    }


    private Material parseMaterial(JSONObject jsonObject){
        String name = jsonObject.getString("name");
        Color color = null;
        ITexture texture = null;

        if(jsonObject.has("$color")){
            color = parseColorType(jsonObject.getString("$color"));
        }else if(jsonObject.has("color")){
            color = parseColorRGB(jsonObject.getJSONArray("color"));
        }

//        Material material = new Material();
        return null;
    }

    private <T, R, K> Optional<T> extract(JSONObject jsonObject, String name, Function<R,T> valueHandler, Function<K,T> typeHandler){
        if(jsonObject.has(name)){
            return new Optional.of(valueHandler.apply((R)));
        }else if(jsonObject.has("color")){
            color = parseColorRGB(jsonObject.getJSONArray("color"));
        }
        return Optional.empty();
    }

    private Color parseColorType(String type) {

    }

    private Color parseColorRGB(JSONArray rgb) {

    }



    @Override
    public boolean canProvide(IResourceKey resourceKey) {
        return resourceKey.getResourceName().equals(MaterialKey.NAME);
    }

    @Override
    public IResourceProvider<Material, MaterialKey> newInstance() {
        return new MaterialProducer(fileLoader);
    }
}
