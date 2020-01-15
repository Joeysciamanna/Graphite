package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.Sprite;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.resource.Resource;

public class ViewModel extends Resource implements IViewModel {

	private IMesh mesh;
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
		viewModel.setMesh(mesh);
		if (texture != null)
			viewModel.setTexture(texture);
		
		return viewModel;
	}

	@Override
	protected void doInit() {
	}

	@Override
	protected void doClose() {
		if (mesh != null)
			mesh.close();
		if (texture != null)
			texture.close();
	}

	public void setTexture(ITexture texture) {
		if(this.texture != null) {
			this.texture.close();
		}
		if (texture.isSprite()) {
			this.mesh.setTextureCoordinates(((Sprite)texture).getTextureCoordinates());
		}
		this.texture = texture;
		texture.init();
	}

	public ITexture getTexture() {
		return texture;
	}

	public Color getColor() {
		return color;
	}

	public IMesh getMesh() {
		return mesh;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setMesh(IMesh mesh) {
		this.mesh = mesh;
	}

}
