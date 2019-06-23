package ch.g_7.java2dengine.base.view;

import ch.g_7.java2dengine.base.mesh.AbstractMesh;
import ch.g_7.java2dengine.texture.Texture;
import ch.g_7.java2dengine.util.Color;

public class BasicViewModel extends AbstractViewModel {

	protected AbstractMesh mesh;
	protected Texture texture;
	protected Color color;
	
	public BasicViewModel() {}
	
	public BasicViewModel(Texture texture, AbstractMesh mesh) {
		this.texture = texture;
		this.mesh = mesh;
	}
	
	public BasicViewModel(Color color, AbstractMesh mesh) {
		this.color = color;
		this.mesh = mesh;
	}
	
	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public AbstractMesh getMesh() {
		return mesh;
	}
	
	public void setMesh(AbstractMesh mesh) {
		this.mesh = mesh;
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	@Override
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

}
