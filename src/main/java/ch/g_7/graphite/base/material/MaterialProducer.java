package ch.g_7.graphite.base.material;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.texture.TextureKey;
import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.helper.Formator;
import ch.g_7.util.io.IFileLoader;
import ch.g_7.util.io.IOUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
        	content = IOUtil.toString(fileLoader.loadFile(path));
        } catch (IOException e) {
            throw new IllegalArgumentException("Material file not found", e);
        }
        return content;
    }


    private Material parseMaterial(JSONObject jsonObject) {
        String name = extract(jsonObject, "name", Object::toString).get();
        Color color = extract(jsonObject, "color", this::parseColorRGB, Color::fromString).get();
        ITexture image = extract(jsonObject, "image", this::parseTexture).orElse(null);
        return new Material(name, color,image);
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
        return ResourceManager.getActive().getEngineResource(new TextureKey(path));
    }


    private int[] parseArea(String coords) {
        List<String> strings = Formator.extract(coords, "[%,%,%,%]");
        int[] ints = new int[4];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.valueOf(strings.get(i));

        }
        return ints;
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

