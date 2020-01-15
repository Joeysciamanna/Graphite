package ch.g_7.graphite.base.texture;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.resource.ResourceHandler;

public class Glyph implements Initializable, AutoCloseable{

	private final static IMesh SQUARE_MESH = MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_TOP_LEFT).build();
	
	private ITexture texture;
	private char character;
	private IMesh mesh;
	
	public Glyph(char character) {
		this.character = character;
		this.mesh = SQUARE_MESH;
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
	
	public void setImage(Image image) {
		this.texture = image;
	}
	
	public void setSprite(Sprite sprite) {
		this.texture = sprite;
//		this.mesh.setTextureCoordinates(sprite.getTextureCoordinates());
	}
	
	public char getCharacter() {
		return character;
	}
	
	public ITexture getTexture() {
		return texture;
	}
	
	public IMesh getMesh() {
		return mesh;
	}
}
