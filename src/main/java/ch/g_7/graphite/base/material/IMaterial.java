package ch.g_7.graphite.base.material;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.util.Color;

public interface IMaterial {
	
	String getName();
	
	Color getColor();
	
	ITexture getTexture();
	

}
