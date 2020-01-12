package ch.g_7.graphite.base.texture;

public class Sprite implements ITexture {

	private float[] textureCoordinates; 
	private Image texture;
	
	Sprite(Image texture, float[] textureCoordinates) {
		this.textureCoordinates = textureCoordinates;
		this.texture = texture;
	}
	
	public float[] getTextureCoordinates() {
		return textureCoordinates;
	}

	@Override
	public void init() {
		texture.init();
	}

	@Override
	public int getId() {
		return texture.getId();
	}

	@Override
	public void bind() {
		texture.bind();
	}

	@Override
	public void unbind() {
		texture.unbind();
	}

	@Override
	public void close() {
		texture.close();
	}

	@Override
	public int getWidth() {
		return texture.getWidth();
	}

	@Override
	public int getHeight() {
		return texture.getHeight();
	}
	
	
}
