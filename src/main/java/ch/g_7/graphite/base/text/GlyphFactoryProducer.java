package ch.g_7.graphite.base.text;

import java.io.IOException;

import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.TextureUtil;

public class GlyphFactoryProducer {

	private static IGlyphFactory glyphFactory;

	public static IGlyphFactory getGlyphFactory() {
		if(glyphFactory == null) {
			SpriteGlyphFactory glyphFactory = new SpriteGlyphFactory();
			try {
				Image image = TextureUtil.loadImage("C:\\Users\\Joey Sciamanna\\git\\Graphite\\src\\main\\resources\\fonts\\font-sprite.png");
				glyphFactory.load(image, 23, 26, 265, 256, "abcdefghijklmnopqrstuvwxyzäöüABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜ1234567890._(){}[]<>\\/*-+=#@%&?»’¦|");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			GlyphFactoryProducer.glyphFactory = glyphFactory;
		}
		return glyphFactory;
	}
	
	public static void setGlyphFactory(IGlyphFactory glyphFactory) {
		GlyphFactoryProducer.glyphFactory = glyphFactory;
	}
	
	
}
