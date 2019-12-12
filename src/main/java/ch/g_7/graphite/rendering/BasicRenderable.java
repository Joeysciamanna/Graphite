package ch.g_7.graphite.rendering;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public interface BasicRenderable extends Renderable {

	Color getColor();
	
	Texture getTexture();

	IMesh getMesh();
	
	
}
