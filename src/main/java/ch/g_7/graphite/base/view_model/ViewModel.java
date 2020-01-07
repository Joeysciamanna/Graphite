package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public class ViewModel {

	private IMesh mesh;
	private Texture texture;
	private Color color;
	
	public ViewModel(IMesh mesh, Texture texture, Color color) {
		this.mesh = mesh;
		this.texture = texture;
		this.color = color;
	}

	public ViewModel() {}
	
	
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
}
