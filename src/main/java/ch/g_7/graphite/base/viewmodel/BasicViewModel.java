package ch.g_7.graphite.base.viewmodel;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public class BasicViewModel implements IViewModel{

	protected Mesh mesh;
	protected Texture texture;
	protected Color color;
	
	public BasicViewModel() {}
	
	public BasicViewModel(Texture texture, Mesh mesh) {
		this.texture = texture;
		this.mesh = mesh;
	}
	
	public BasicViewModel(Color color, Mesh mesh) {
		this.color = color;
		this.mesh = mesh;
	}
	
	@Override
	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	@Override
	public Mesh getMesh() {
		return mesh;
	}
	
	public void setMesh(Mesh mesh) {
		this.mesh = mesh;
	}
	
	@Override
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void close() {
		if(texture!=null) {
			texture.close();
		}
		mesh.close();
	}

}
