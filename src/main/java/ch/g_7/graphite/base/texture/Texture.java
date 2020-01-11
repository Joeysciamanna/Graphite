package ch.g_7.graphite.base.texture;

import static org.lwjgl.opengl.GL11.glDeleteTextures;

import java.io.IOException;

import ch.g_7.graphite.util.ResourceHandler;
import ch.g_7.util.able.Initializable;

public class Texture implements AutoCloseable, Initializable{

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

	public static Texture getTexture(String absolutePath, int width, int height) throws IOException {
		return TextureUtil.toTexture(TextureUtil.loadTexture(absolutePath), width, height);
	}
	

	public static Texture getSprite(String absolutePath, int textureWidth, int textureHeight, int x, int y, int width, int height) throws IOException {
		return TextureUtil.extractSprite(TextureUtil.loadTexture(absolutePath), textureWidth, textureHeight, x, y, width, height);
	}
	
	@Override
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}
	
	protected void doInit() {}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallInitialize(this)) doClose();
	}
	
	protected void doClose() {
		glDeleteTextures(id);
	}


}
