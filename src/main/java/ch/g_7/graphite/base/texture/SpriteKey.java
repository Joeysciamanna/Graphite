package ch.g_7.graphite.base.texture;

import ch.g_7.util.helper.Util;

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
		return Util.isEqual(this, obj, SpriteKey::getX, SpriteKey::getY, SpriteKey::getWidth, SpriteKey::getHeight, SpriteKey::getName);
	}
	
	
}




