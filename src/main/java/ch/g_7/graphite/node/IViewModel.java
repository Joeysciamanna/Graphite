package ch.g_7.graphite.node;

import ch.g_7.graphite.base.material.IMaterial;
import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.node.IRenderResource;
import ch.g_7.graphite.rendering.IRenderType;

public interface IViewModel extends IRenderResource {

	IRenderType<?> getRenderType();

}
