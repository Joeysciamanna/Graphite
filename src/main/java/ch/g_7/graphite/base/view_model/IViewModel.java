package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.common.Initializable;

public interface IViewModel extends Initializable, AutoCloseable {

	ITexture getTexture();
	
	Color getColor();
	
	IMesh getMesh();
	
	void close();

	void bind();
	
	void unbind();
}
