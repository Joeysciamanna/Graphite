package ch.g_7.graphite.base.texture;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.mesh.vao.VBOFactory;
import org.lwjgl.opengl.GL11;

import ch.g_7.util.resource.Resource;

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

	public float getxMax() {
		return xMax;
	}
	
	public float getxMin() {
		return xMin;
	}
	
	public float getyMax() {
		return yMax;
	}

	public float getyMin() {
		return yMin;
	}
	
	@Override
	public void allocate() {
	}

	@Override
	public void extinguish() {
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
