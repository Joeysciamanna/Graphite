package ch.g_7.graphite.base.material;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.mesh.vao.VBOFactory;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.texture.ImageKey;
import ch.g_7.graphite.resource.*;
import ch.g_7.graphite.util.Color;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
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


    private Material parseMaterial(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Color color = extract(jsonObject, "color", this::parseColorRGB, Color::fromString).get();
        ITexture image = extract(jsonObject, "image", this::parseTexture).orElse(null);
        ITexture sprite = extract(jsonObject, "sprite", this::parseSprite).orElse(null);

        return new Material(name, color, image == null ? sprite : image, new VBO[]{});
    }

    @SuppressWarnings("unchecked")
    private <R, K, T> Optional<R> extract(JSONObject jsonObject, String name, Function<K, R> valueHandler, Function<T, R> typeHandler) {
        R value = null;
        if (jsonObject.has(name)) {
            value = valueHandler.apply((K) jsonObject.get(name));
        } else if (jsonObject.has("$" + name)) {
            if (value != null)
                throw new IllegalArgumentException("Both value and type was supplied for [" + name + "]");
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
        return ResourceManager.getActive().getResource(new ImageKey(path));
    }

    private ITexture parseSprite(JSONObject value) {
        throw new RuntimeException("Sprites are currently not supported");
    }

    private final static String numberChars = "1234567890.";
    private float[] parseArea(String coords) {
        float[] box = new float[4];
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
        return new MaterialProducer(fileLoader);
    }
}
