package ch.g_7.graphite.base.texture;

import org.lwjgl.opengl.GL11;

import ch.g_7.util.resource.Resource;

public class Sprite extends Resource implements ITexture {

	private float[] textCoords;
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
		this.textCoords = textCoords;
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
	public void doInit() {
		image.bind(this);
	}

	@Override
	public void doClose() {
		image.unbind(this);
	}
	
	@Override
	public int getId() {
		return image.getId();
	}

	@Override
	public void bind() {
		image.bind();
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
//		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
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

	public float[] getTextureCoordinates() {
		return textCoords;
	}
	
	@Override
	public boolean isSprite() {
		return true;
	}
}
