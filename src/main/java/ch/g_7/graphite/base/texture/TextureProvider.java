package ch.g_7.graphite.base.texture;

import java.io.IOException;
import java.io.InputStream;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.util.io.IFileLoader;
import ch.g_7.util.io.IResourceLoader;


public class TextureProvider extends BasicResourceProvider<Texture, TextureKey> {

    @Override
    protected Texture loadResource(TextureKey resourceKey, IResourceLoader resourceLoader) throws IllegalArgumentException {
    	return loadTexture(resourceLoader.loadResourceThrowRuntime(resourceKey.getName()));
    }

    private Texture loadTexture(InputStream inputStream) {
        Texture image = null;
        try {
            image = TextureLoader.loadImage(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Exception at loading Texture", e);
        }
        return image;
    }

    @Override
    public boolean canProvide(IResourceKey resourceKey) {
    	return containsResourceNames(resourceKey, TextureKey.NAME);
    }

    @Override
    public IResourceProvider<Texture, TextureKey> newInstance() {
        return new TextureProvider();
    }

}
