package ch.g_7.graphite.base.texture;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IFileLoader;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.graphite.resource.ResourceManager;

import java.io.IOException;

/**
 * Resource name must end with .png for images,
 * or wit .png[x,y,width,height] for sprites
 */
public class TextureProvider extends BasicResourceProvider<ITexture> {

    private IFileLoader fileLoader;

    public TextureProvider(IFileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    @Override
    protected ITexture loadResource(String resourceName) throws IllegalArgumentException {
        if(resourceName.endsWith(".png")){
            return loadImage(resourceName);
        }
        String imagePath = resourceName.substring(0, resourceName.indexOf(".png"));
        Image image = (Image) get(imagePath);
        //TODO
        return loadSprite(image, 0,0,0,0);
    }

    private Image loadImage(String path) {
        Image image = null;
        try {
            image = TextureUtil.loadImage(path);
        } catch (IOException e) {
            new RuntimeException("Image not found", e);
        }
        image.init();
        return image;
    }

    private Sprite loadSprite(Image image, int x, int y, int width, int height){
        return TextureUtil.loadSprite(image, x, y, width, height);
    }

    @Override
    public boolean canProvide(String resourceName) {
        return resourceName.endsWith(".png") || resourceName.matches(".*\\.png\\[[0-9]+,[0-9]+,[0-9]+,[0-9]+\\]");
    }

    @Override
    public IResourceProvider<ITexture> newInstance() {
        return new TextureProvider(fileLoader);
    }

    @Override
    public String getName() {
        throw new RuntimeException("Method not supported");
    }
}
