package ch.g_7.graphite.draw.object;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.node.Localizable;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.able.Initializable;

public interface IDrawObject extends Localizable, Initializable, AutoCloseable {

	IMesh getMesh();
	
	Texture getTexture();
	
	Color getColor();
	
	int getGLDrawMethod();
	
	void close();
}
