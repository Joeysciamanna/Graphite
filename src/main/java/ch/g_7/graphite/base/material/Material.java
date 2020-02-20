package ch.g_7.graphite.base.material;

import java.util.Optional;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.resource.IResource;
import ch.g_7.graphite.util.Color;

public class Material implements IMaterial, IResource {

	private String name;
    private Color color;
    private Optional<ITexture> texture;


    public Material(String name, Color color, ITexture texture, VBO[] vbos) {
    	this.name = name;
        this.color = color;
        this.texture = Optional.ofNullable(texture);
    }

  
    
    
    @Override
    public String getName() {
    	return name;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Optional<ITexture> getTexture() {
        return texture;
    }

    @Override
    public VBO[] getVBOs() {
        return getVBOs();
    }

    @Override
    public void close() { }

    @Override
    public void init() { }
}
