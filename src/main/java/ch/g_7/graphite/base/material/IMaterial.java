package ch.g_7.graphite.base.material;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.rendering.IRenderResource;
import ch.g_7.graphite.util.Color;

public interface IMaterial extends IRenderResource {
	
	String getName();

	ITexture getTexture();

	Color getAmbient();

	Color getDiffuse();

	Color getSpecular();

	float getShininess();

}
