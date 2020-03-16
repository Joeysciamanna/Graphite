package ch.g_7.graphite.base.material;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.resource.IResource;
import ch.g_7.graphite.util.Color;

public class Material implements IMaterial, IResource {

    private final String name;
    private final ITexture texture;
    private final Color ambient;
    private final Color diffuse;
    private final Color specular;
    private final float shininess;

    public Material(String name, ITexture texture, Color ambient, Color diffuse, Color specular, float shininess) {
        this.name = name;
        this.texture = texture;
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
        this.shininess = shininess;
    }

    public Material(String name, Color ambient, Color diffuse, Color specular, float shininess) {
        this(name, null, ambient, diffuse, specular, shininess);
    }

    public Material(String name, Color ambient) {
        this(name, null, ambient, Color.TRANSPARENT, Color.TRANSPARENT, 0);
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
        return ambient;
    }

    @Override
    public Color getDiffuse() {
        return diffuse;
    }

    @Override
    public Color getSpecular() {
        return specular;
    }

    @Override
    public float getShininess() {
        return shininess;
    }

    @Override
    public void bind() {
        if(texture != null) texture.bind();
    }

    @Override
    public void unbind() {
        if(texture != null) texture.unbind();
    }

    @Override
    public void close() { }

    @Override
    public void init() { }



}
