package ch.g_7.graphite.base.text;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ch.g_7.graphite.base.texture.Texture;

public class SpriteGlyphFactory implements IGlyphFactory {

	private Map<Character, Texture> glyphs;
	
	
	public SpriteGlyphFactory() {
		glyphs = new HashMap<>();
	}
	
	@Override
	public Texture getGlyph(char glyph) {
		return glyphs.get(glyph);
	}
	
	
	public void load(String spritePath, int glyphWidth, int glyphHeight, int textureWidth, int textureHeight, String glyphOrder) throws IOException {
		char[] chars = glyphOrder.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			Texture texture = Texture.getSprite(spritePath, textureWidth, textureHeight, glyphWidth*i, 0, glyphWidth, glyphHeight);
			
			
		}
	}

}
