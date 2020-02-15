package ch.g_7.graphite.base.texture;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDeleteTextures;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.mesh.vao.VBOFactory;
import ch.g_7.graphite.resource.ResourceManager;

public class Image implements ITexture {

	private final static VBO TEXTURE_COORDINATES = VBOFactory.getTextureCoordinatesVBO(new float[] {
			0,1,
			1,1,
			1,0,
			0,0,
	});

	private int id;
	private int width;
	private int height;

	Image(int id, int width, int height) {
		this.id = id;
		this.width = width;
		this.height = height;
	}

	@Override
	public VBO getTextureCoordinatesVBO() {
		return TEXTURE_COORDINATES;
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
		glActiveTexture(GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, id);
	}
	
	@Override
	public void unbind() {}

}
