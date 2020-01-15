package ch.g_7.graphite.base.texture;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDeleteTextures;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

import ch.g_7.util.resource.Resource;

public class Image extends Resource implements ITexture {

	private int id;
	private int width;
	private int height;

	Image(int id, int width, int height) {
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
	
	protected void doInit() {
	}

	protected void doClose() {
		glDeleteTextures(id);
	}

	@Override
	public void bind() {
		glActiveTexture(GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, id);
	}

	@Override
	public void unbind() {}
	
	@Override
	public boolean isSprite() {
		return false;
	}

}
