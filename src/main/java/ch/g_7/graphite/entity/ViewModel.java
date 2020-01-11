package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.able.Initializable;

public class ViewModel implements Initializable, AutoCloseable{

	private IMesh mesh;
	private Texture texture;
	private Color color;
	
	public ViewModel(IMesh mesh, Texture texture, Color color) {
		this.mesh = mesh;
		this.texture = texture;
		this.color = color;
	}

	public ViewModel() {
		this.color = Color.getColor(0, 0, 0);
	}
	
	
	public Color getColor() {
		return color;
	}
	
	public IMesh getMesh() {
		return mesh;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setMesh(IMesh mesh) {
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
