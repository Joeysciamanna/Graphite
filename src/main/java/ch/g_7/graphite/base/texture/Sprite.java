package ch.g_7.graphite.base.texture;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.mesh.vao.VBOFactory;
import org.lwjgl.opengl.GL11;


public class Sprite implements ITexture {

	private VBO textureCoordinates;
	private float xMin, yMin, xMax, yMax;
	private Image image;


//	Sprite(Image image, float xMax, float yMax, float xMin, float yMin) {
//		this.image = image;
//		this.xMax = xMax;
//		this.yMax = yMax;
//		this.xMin = xMin;
//		this.yMin = yMin;
//	}

	Sprite(Image image, float[] textCoords) {
		this.image = image;
		this.textureCoordinates = VBOFactory.getTextureCoordinatesVBO(textCoords);
	}

	@Deprecated
	public float getxMax() {
		return xMax;
	}

	@Deprecated
	public float getxMin() {
		return xMin;
	}

	@Deprecated
	public float getyMax() {
		return yMax;
	}

	@Deprecated
	public float getyMin() {
		return yMin;
	}
	
	@Override
	public void init() {
		image.init();
	}

	@Override
	public void close() {
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
		return (int) ((xMax - xMin) * image.getWidth());
	}

	@Override
	public int getHeight() {
		return (int) ((yMax - yMin) * image.getHeight());
	}

	@Override
	public VBO getTextureCoordinatesVBO() {
		return textureCoordinates;
	}
}
