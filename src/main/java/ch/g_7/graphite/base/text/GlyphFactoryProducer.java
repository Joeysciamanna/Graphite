package ch.g_7.graphite.base.text;

public class GlyphFactoryProducer {

	private static IGlyphFactory glyphFactory;
	
	public static IGlyphFactory getGlyphFactory() {
		return glyphFactory;
	}
	
	public static void setGlyphFactory(IGlyphFactory glyphFactory) {
		GlyphFactoryProducer.glyphFactory = glyphFactory;
	}
	
	
}
