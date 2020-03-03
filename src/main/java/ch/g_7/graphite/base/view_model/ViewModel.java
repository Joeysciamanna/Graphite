package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.node.IRenderResource;
import ch.g_7.graphite.resource.IResource;
import ch.g_7.graphite.util.Color;


public class ViewModel implements IViewModel, IResource, IRenderResource {

	private IMesh mesh;
	private ITexture texture;
	private Color color;

	@Deprecated
	public ViewModel(IMesh mesh, ITexture texture, Color color) {
		this.mesh = mesh;
		this.texture = texture;
		this.color = color;
	}


	@Override
	public void bind() {
		if (texture != null)
			texture.bind();
		mesh.bind();
	}

	@Override
	public void unbind() {
		if (texture != null)
			texture.unbind();
		mesh.unbind();
	}

	public ITexture getTexture() {
		return texture;
	}

	public void setTexture(ITexture texture) {
		this.texture = texture;
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
		this.mesh = mesh;
	}

	@Override
	public void close() {

	}

	@Override
	public void init() {

	}
}
