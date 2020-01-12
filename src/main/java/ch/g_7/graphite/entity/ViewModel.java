package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.Sprite;
import ch.g_7.graphite.util.Color;
import ch.g_7.graphite.util.ResourceHandler;
import ch.g_7.util.able.Initializable;

public class ViewModel implements Initializable, AutoCloseable{

	private IMesh mesh;
	private ITexture texture;
	private Color color;
	
	public ViewModel(IMesh mesh, Image texture, Color color) {
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
	
	public ITexture getTexture() {
		return texture;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setMesh(IMesh mesh) {
		this.mesh = mesh;
	}
	
	public void setImage(Image image) {
		this.texture = image;
	}

	public void setSprite(Sprite sprite) {
		this.texture = sprite;
		this.mesh.setTextureCoordinates(sprite.getTextureCoordinates());
	}
	
	@Override
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}
	
	protected void doInit() {
		if(mesh!=null) mesh.init();
		if(texture!=null) texture.init();
	}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallClose(this)) doClose();
	}

	protected void doClose() {
		if(mesh!=null) mesh.close();
		if(texture!=null) texture.close();
	}
	
	
}
