package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.mesh.IMesh3d;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.able.Initializable;

public class ViewModel implements Initializable, AutoCloseable{

	private IMesh3d mesh;
	private Texture texture;
	private Color color;
	
	public ViewModel(IMesh3d mesh, Texture texture, Color color) {
		this.mesh = mesh;
		this.texture = texture;
		this.color = color;
	}

	public ViewModel() {}
	
	
	public Color getColor() {
		return color;
	}
	
	public IMesh3d getMesh() {
		return mesh;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setMesh(IMesh3d mesh) {
		this.mesh = mesh;
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	@Override
	public void close() {
		if(mesh!=null) mesh.close();
		if(texture!=null) texture.close();

	}

	@Override
	public void init() {
		if(mesh!=null) mesh.init();
	}
}
