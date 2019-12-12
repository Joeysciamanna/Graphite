package ch.g_7.graphite.rendering;

import ch.g_7.graphite.base.mesh.IMesh2d;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public interface Basic2dRenderable extends Renderable {

	Color getColor();
	
	Texture getTexture();

	IMesh2d getMesh();
	
	
}
