package ch.g_7.graphite.base.texture;

import ch.g_7.util.resource.IDepender;
import ch.g_7.util.resource.Resource;

public class Sprite extends Resource implements ITexture, IDepender {

	private float xMin, yMin, xMax, yMax;
	private Image image;
	
	
	Sprite(Image image, float xMin, float yMin, float xMax, float yMax) {
		this.image = image;
		this.xMin = xMin;
		this.yMin = yMin;
		this.xMax = xMax;
		this.yMax = yMax;
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
		return new float[] {
				xMin, yMax,
				xMax, yMax,
				xMax, yMin,
				xMin, yMin
			};
	}
	
	@Override
	public boolean isSprite() {
		return true;
	}
}
