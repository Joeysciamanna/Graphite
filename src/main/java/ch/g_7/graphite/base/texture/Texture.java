package ch.g_7.graphite.base.texture;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDeleteTextures;

import ch.g_7.graphite.resource.IResource;

public class Texture implements ITexture, IResource {

	private int id;
	private int width;
	private int height;

	Texture(int id, int width, int height) {
		this.id = id;
		this.width = width;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}

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
