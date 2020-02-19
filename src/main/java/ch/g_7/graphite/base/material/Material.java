package ch.g_7.graphite.base.material;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.resource.IResource;
import ch.g_7.graphite.util.Color;

public class Material implements IMaterial, IResource {

	private String name;
    private Color color;
    private ITexture texture;
    private final VBO[] vbos;

    public Material(String name, Color color, ITexture texture, VBO[] vbos) {
    	this.name = name;
        this.color = color;
        this.texture = texture;
        this.vbos = combine(new VBO[]{ texture.getTextureCoordinatesVBO() }, vbos);
    }

    private final static VBO[] combine(VBO[] vbos1,  VBO... vbos2){
        VBO[] vbos = new VBO[vbos1.length + vbos2.length];
        int i = 0;
        for (VBO vbo : vbos1) vbos[i++] = vbo;
        for (VBO vbo : vbos2) vbos[i++] = vbo;
        return vbos;
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
    public ITexture getTexture() {
        return texture;
    }

    @Override
    public VBO[] getVBOs() {
        return vbos;
    }

    @Override
    public void close() { }

    @Override
    public void init() { }
}