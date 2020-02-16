package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.util.Color;
import ch.g_7.graphite.util.IColor;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

@Deprecated
public interface IViewModel {

	ITexture getTexture();
	
	IColor getColor();
	
	IMesh getMesh();

	void bind();
	
	void unbind();
}
