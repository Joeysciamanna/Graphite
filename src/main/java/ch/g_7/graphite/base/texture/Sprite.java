package ch.g_7.graphite.base.texture;

import org.lwjgl.opengl.GL11;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.mesh.vao.VBOFactory;


public class Sprite implements ITexture {

	private VBO textureCoordinates;
	private Image image;


	Sprite(Image image, float[] textCoords) {
		this.image = image;
		this.textureCoordinates = VBOFactory.getTextureCoordinatesVBO(textCoords);
	}

	
	@Override
	public void init() {
		image.init();
	}

	@Override
	public void close() {
		textureCoordinates.close();
		image.close();
	}
	
	@Override
	public int getId() {
		return image.getId();
	}

	@Override
	public void bind() {
		image.bind();
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
	}

	@Override
	public void unbind() {
		image.unbind();
	}

	@Override
	public int getWidth() {
		return image.getWidth();
	}

	@Override
	public int getHeight() {
		return image.getHeight();
	}

	@Override
	public VBO getTextureCoordinatesVBO() {
		return textureCoordinates;
	}
}
