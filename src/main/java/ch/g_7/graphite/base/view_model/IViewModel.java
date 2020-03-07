package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.base.material.IMaterial;
import ch.g_7.graphite.base.mesh.IMesh;

public interface IViewModel {

	IMaterial getMaterial();
	
	IMesh getMesh();

	void bind();
	
	void unbind();
}
