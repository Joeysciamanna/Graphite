package ch.g_7.graphite.node;

import ch.g_7.graphite.rendering.IRenderResource;
import ch.g_7.graphite.rendering.IRenderType;

public interface IViewModel extends IRenderResource {

	IRenderType<?> getRenderType();

}
