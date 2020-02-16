package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.util.IColor;

public interface IViewModel {

	ITexture getTexture();
	
	IColor getColor();
	
	IMesh getMesh();

	void bind();
	
	void unbind();
}
