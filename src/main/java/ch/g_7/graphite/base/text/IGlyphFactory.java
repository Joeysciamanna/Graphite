package ch.g_7.graphite.base.text;

import ch.g_7.graphite.base.texture.Glyph;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.Sprite;

public interface IGlyphFactory {

	
	public Glyph getGlyph(char character);
	
	public default Image getImage(char character) {
		throw new UnsupportedOperationException("getImage is not supported");
	}
	
	public default Sprite getSprite(char character) {
		throw new UnsupportedOperationException("getSprite is not supported");
	}
}
