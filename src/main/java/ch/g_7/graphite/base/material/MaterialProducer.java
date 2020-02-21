package ch.g_7.graphite.base.material;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.function.Function;

import org.json.JSONArray;
import org.json.JSONObject;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.texture.ImageKey;
import ch.g_7.graphite.base.texture.SpriteKey;
import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IFileLoader;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.graphite.util.Color;

public class MaterialProducer extends BasicResourceProvider<Material, MaterialKey> {


    @Override
    protected Material loadResource(MaterialKey resourceKey, IFileLoader fileLoader) throws IllegalArgumentException {
        String content = readFile(resourceKey.getName(), fileLoader);
        JSONObject jsonObject = new JSONObject(content);
        Material material = parseMaterial(jsonObject);
        return material;
    }


    private String readFile(String path, IFileLoader fileLoader) {
        String content;
        try {
            File file = fileLoader.loadFile(path);
            content = Files.readString(file.toPath());
        } catch (IOException e) {
            throw new IllegalArgumentException("Material file not found", e);
        }
        return content;
    }


    private Material parseMaterial(JSONObject jsonObject) {
        String name = extract(jsonObject, "name", Object::toString).get();
        Color color = extract(jsonObject, "color", this::parseColorRGB, Color::fromString).get();
        ITexture image = extract(jsonObject, "image", this::parseTexture).orElse(null);
        ITexture sprite = extract(jsonObject, "sprite", this::parseSprite).orElse(null);
        if(image != null && sprite != null) throw new IllegalArgumentException("Both, Image and Sprite is present");
        return new Material(name, color, image == null ? sprite : image);
    }

    @SuppressWarnings("unchecked")
    private <R, K, T> Optional<R> extract(JSONObject jsonObject, String name, Function<K, R> valueHandler, Function<T, R> typeHandler) {
        R value = null;
        if (jsonObject.has(name)) {
            value = valueHandler.apply((K) jsonObject.get(name));
        } 
        if (jsonObject.has("$" + name)) {
            if (value != null)
                throw new IllegalArgumentException("Both value and type was present for [" + name + "]");
            value = typeHandler.apply((T) jsonObject.get("$" + name));
        }
        return Optional.ofNullable(value);
    }

    @SuppressWarnings("unchecked")
    private <R, T> Optional<R> extract(JSONObject jsonObject, String name, Function<T, R> valueHandler) {
        if (jsonObject.has(name)) {
            return Optional.of(valueHandler.apply((T) jsonObject.get(name)));
        }
        return Optional.empty();
    }


    private Color parseColorRGB(JSONArray array) {
        if (array.length() == 3)
            return new Color(array.getInt(0), array.getInt(1), array.getInt(2));
        return new Color(array.getInt(0), array.getInt(1), array.getInt(2), array.getInt(3));
    }

    private ITexture parseTexture(String path) {
        return ResourceManager.getActive().getEngineResource(new ImageKey(path));
    }

    private ITexture parseSprite(JSONObject value) {
        int[] area = extract(value, "area", this::parseArea).get();
        String path = extract(value, "src", Object::toString).get();
        return ResourceManager.getActive().getEngineResource(new SpriteKey(path, area[0], area[1], area[2], area[3]));
    }

    private final static String numberChars = "1234567890";
    private int[] parseArea(String coords) {
        int[] box = new int[4];
        StringBuilder number = new StringBuilder();
        int i = 0;
        for (char c : coords.toCharArray()) {
            if (c == ',') {
                box[i++] = Integer.valueOf(number.toString());
                number.setLength(0);
            } else if (numberChars.indexOf(c) != -1) {
                number.append(c);
            } else if (c != ' '){
                throw new IllegalArgumentException("Invalid formatted sprite area");
            }
        }
        return box;
    }


    @Override
    public boolean canProvide(IResourceKey resourceKey) {
        return resourceKey.getResourceName().equals(MaterialKey.NAME);
    }

    @Override
    public IResourceProvider<Material, MaterialKey> newInstance() {
        return new MaterialProducer();
    }
}

