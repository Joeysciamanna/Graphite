package ch.g_7.graphite.base.material;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.texture.ImageKey;
import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IFileLoader;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.graphite.resource.ResourceManager;
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
        Color color = extract(jsonObject, "color", this::parseColorRGB, Color::fromString).get();
        ITexture texture = extract(jsonObject, "texture", this::parseTexture).orElse(null);

        return new Material(name, color, texture, null);
    }

    @SuppressWarnings("unchecked")
	private <R, K, T> Optional<R> extract(JSONObject jsonObject, String name, Function<K, R> valueHandler, Function<T,R> typeHandler){
        if(jsonObject.has(name)){
            return Optional.of(valueHandler.apply((K)jsonObject.get(name)));
        }else if(jsonObject.has("$" + name)){
        	 return Optional.of(typeHandler.apply((T)jsonObject.get("$" + name)));
        }
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
	private <R, T> Optional<R> extract(JSONObject jsonObject, String name, Function<T, R> valueHandler){
    	 if(jsonObject.has(name)){
             return Optional.of(valueHandler.apply((T)jsonObject.get(name)));
    	 }
         return Optional.empty();
    }
   

    private Color parseColorRGB(JSONArray array) {
    	if(array.length()==3) 
    		return new Color(array.getInt(0),array.getInt(1),array.getInt(2));
    	return new Color(array.getInt(0),array.getInt(1),array.getInt(2), array.getInt(3));
    }

    private ITexture parseTexture(String path) {
    	return ResourceManager.getActive().getResource(new ImageKey(path));
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
