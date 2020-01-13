package ch.g_7.graphite.base.texture;

public class Sprite implements ITexture {

	private float xMin, yMin, xMax, yMax;
	private Image image;
	
	
	Sprite(Image image, float xMin, float yMin, float xMax, float yMax) {
		this.image = image;
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
	public void init() {
		image.init();
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
	public void close() {
		image.close();
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
				xMin, xMin,
				xMin, yMax,
				xMax, yMax,
				xMax, yMin
			};
	}
	
	@Override
	public boolean isSprite() {
		return true;
	}
}
