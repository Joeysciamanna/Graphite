package ch.g_7.graphite.base.view_model;

import java.util.Objects;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.mesh.vao.IVBOType;
import ch.g_7.graphite.base.mesh.vao.VAO;
import ch.g_7.graphite.base.mesh.vao.VBOType;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.resource.IResource;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.graphite.util.Color;


public class ViewModel implements IViewModel, IResource {

	private final VAO vao;
	private IMesh mesh;
	private ITexture texture;
	private Color color;

	@Deprecated
	public ViewModel(IMesh mesh, ITexture texture, Color color) {
		this.vao = new VAO(new IVBOType[]{VBOType.POSITIONS, VBOType.INDICES, VBOType.TEXTURE_COORDINATES});

		this.mesh = mesh;
		vao.add(mesh.getPositionVBO());
		
		this.texture = texture;
		if (texture != null)
			this.vao.add(texture.getTextureCoordinatesVBO());
		
		setColor(color);
		init();
	}

	@Override
	public ViewModel clone() {
		return new ViewModel(mesh, texture, color);
	}


	@Override
	public void bind() {
		if (texture != null)
			texture.bind();
		vao.bind();
	}

	@Override
	public void unbind() {
		if (texture != null)
			texture.unbind();
		vao.unbind();
	}

	public ITexture getTexture() {
		return texture;
	}

	public void setTexture(ITexture texture) {
		this.texture = texture;
		if (texture != null)
			this.vao.replace(texture.getTextureCoordinatesVBO());
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		Objects.requireNonNull(color);
		this.color = color;
	}

	public IMesh getMesh() {
		return mesh;
	}

	public void setMesh(IMesh mesh) {
		this.mesh = mesh;
		this.vao.replace(mesh.getPositionVBO());
	}


	@Override
	public void close() {
		vao.close();
	}

	@Override
	public void init() { }
}
