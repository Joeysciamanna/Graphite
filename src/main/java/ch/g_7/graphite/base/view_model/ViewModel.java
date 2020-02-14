package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.mesh.vao.VAO;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.Sprite;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.resource.Resource;

public class ViewModel extends Resource implements IViewModel {

	private IMesh mesh;
	private VAO vao;
	private ITexture texture;
	private Color color;

	public ViewModel(IMesh mesh, Image texture, Color color) {
		this.mesh = mesh;
		this.texture = texture;
		this.color = color;
	}

	public ViewModel() {
		this.color = Color.getColor(0, 0, 0, 0);
	}

	@Override
	public void bind() {
		if (texture != null)
			texture.bind();
	}

	@Override
	public void unbind() {
		if (texture != null)
			texture.unbind();
	}

	@Override
	public ViewModel clone() {
		ViewModel viewModel = new ViewModel();
		viewModel.setColor(color);
		if(mesh != null)
			viewModel.setMesh(mesh.clone());
		if (texture != null)
			viewModel.setTexture(texture);
		
		return viewModel;
	}

	@Override
	protected void doInit() {
		bindTo(mesh, texture);
	}

	@Override
	protected void doClose() {
		unbindFrom(mesh, texture);
	}

	public ITexture getTexture() {
		return texture;
	}

	public void setTexture(ITexture texture) {
		unbindFrom(this.texture);
		if (texture.isSprite()) {
			this.mesh.setTextureCoordinates(((Sprite)texture).getTextureCoordinates());
		}
		this.texture = texture;
		bindTo(this.texture);
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public IMesh getMesh() {
		return mesh;
	}

	public void setMesh(IMesh mesh) {
		unbindFrom(this.mesh);
		this.mesh = mesh;
		bindTo(mesh);
	}

}
