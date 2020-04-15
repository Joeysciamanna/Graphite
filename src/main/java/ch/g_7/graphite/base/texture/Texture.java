package ch.g_7.graphite.base.texture;

import ch.g_7.graphite.resource.IResource;

import static org.lwjgl.opengl.GL11.*;

public class Texture implements ITexture, IResource {

	private int id;
	private int width;
	private int height;

	public Texture(int id, int width, int height) {
		this.id = id;
		this.width = width;
		this.height = height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public void init() { }

	@Override
	public void close() {
		glDeleteTextures(id);
	}

	@Override
	public void bind() {
		glBindTexture(GL_TEXTURE_2D, id);
	}
	
	@Override
	public void unbind() {}

}
