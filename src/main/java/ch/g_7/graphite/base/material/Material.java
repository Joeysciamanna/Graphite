package ch.g_7.graphite.base.material;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.resource.IResource;
import ch.g_7.graphite.util.Color;

public class Material implements IMaterial, IResource {

	private final String name;
    private final Color color;
    private final ITexture texture;

    public Material(String name, Color color, ITexture texture) {
    	this.name = name;
        this.color = color;
        this.texture = texture;
    }

    
    @Override
    public String getName() {
    	return name;
    }

    @Override
    public ITexture getTexture() {
        return texture;
    }

    @Override
    public Color getAmbient() {
        return null;
    }

    @Override
    public Color getDiffuse() {
        return null;
    }

    @Override
    public Color getSpecular() {
        return null;
    }

    @Override
    public float getShininess() {
        return 0;
    }

    @Override
    public void bind() {

    }

    @Override
    public void unbind() {

    }

    @Override
    public void close() { }

    @Override
    public void init() { }



}
