package ch.g_7.graphite.base.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.texture.Glyph;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.Sprite;
import ch.g_7.graphite.base.texture.TextureUtil;

public class SpriteGlyphFactory implements IGlyphFactory {

	private List<Glyph> glyphs;
	
	
	public SpriteGlyphFactory() {
		glyphs = new ArrayList<>();
	}
	
	@Override
	public Glyph getGlyph(char character) {
		for (Glyph glyph : glyphs) {
			if(glyph.getCharacter() == character) {
				return glyph;
			}
		}
		throw new IllegalArgumentException("Glyph " + character + " does not exist");
	}
	
	@Override
	public Sprite getSprite(char character) {
		return (Sprite) getGlyph(character).getTexture();
	}
	
	public void load(Image image, int glyphWidth, int glyphHeight, int textureWidth, int textureHeight, String glyphOrder) throws IOException {
		char[] chars = glyphOrder.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int x = i % textureWidth;
			int y = i / textureWidth;
			Glyph glyph = new Glyph(chars[i]);
			glyph.init();
			glyph.setSprite(TextureUtil.loadSprite(image, x, y, glyphWidth, glyphHeight)); 
			glyphs.add(glyph);
		}
	}
	
	
	public void unload() {
		glyphs.clear();
	}

}
