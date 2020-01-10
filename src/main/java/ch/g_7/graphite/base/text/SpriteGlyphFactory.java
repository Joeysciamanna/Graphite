package ch.g_7.graphite.base.text;

import java.util.Map;

import ch.g_7.graphite.base.texture.Texture;

public class SpriteGlyphFactory implements IGlyphFactory {

	private Map<Character, Texture> glyphs;
	
	
	@Override
	public Texture getGlyph(char glyph) {
		return glyphs.get(glyph);
	}
	
	
	public void load(String spritePath, int spriteWidth, int spriteHeight, String glyphOrder) {
		
	}

}
