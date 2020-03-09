package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.base.material.IMaterial;
import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.node.IRenderResource;

public interface IViewModel extends IRenderResource {

	IMaterial getMaterial();
	
	IMesh getMesh();

}
