package ch.g_7.graphite.base.texture;

import java.io.IOException;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.util.io.IFileLoader;


public class TextureProvider extends BasicResourceProvider<ITexture, ImageKey> {


    @Override
    protected ITexture loadResource(ImageKey resourceKey, IFileLoader fileLoader) throws IllegalArgumentException {
        if(resourceKey.getResourceName().equals(ImageKey.NAME)){
            return loadImage(fileLoader.loadFile(resourceKey.getName()).getAbsolutePath().replace("%20", " "));
        }
        SpriteKey spriteKey = (SpriteKey) resourceKey;
    	Image image = (Image) get(new ImageKey(spriteKey.getName()), fileLoader);
        return loadSprite(image, spriteKey.getX(), spriteKey.getY(), spriteKey.getWidth(), spriteKey.getHeight());
     
    }

    private Image loadImage(String path) {
        Image image = null;
        try {
            image = TextureLoader.loadImage(path);
        } catch (IOException e) {
            throw new RuntimeException("Image not found", e);
        }
        return image;
    }

    private Sprite loadSprite(Image image, int x, int y, int width, int height){
        return TextureLoader.loadSprite(image, x, y, width, height);
    }

    @Override
    public boolean canProvide(IResourceKey resourceKey) {
    	return resourceKey.getResourceName().equals(ImageKey.NAME) || resourceKey.getResourceName().equals(SpriteKey.NAME);
    }

    @Override
    public IResourceProvider<ITexture, ImageKey> newInstance() {
        return new TextureProvider();
    }

}
