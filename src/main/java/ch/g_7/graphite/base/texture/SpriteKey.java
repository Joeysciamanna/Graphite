package ch.g_7.graphite.base.texture;

public class SpriteKey extends ImageKey {

	public final static String NAME = "SPRITE";
	
	private int x, y, width, height;
	
	public SpriteKey(String path, int x, int y, int width, int height) {
		super(path);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	@Override
	public String getResourceName() {
		return NAME;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SpriteKey) {
			SpriteKey other = (SpriteKey) obj;
			return other.x == x && other.y == y && other.width == width && other.height == height && other.getPath().equals(getPath());
			
		}
		return false;
	}
	
	
}




