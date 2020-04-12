package ch.g_7.graphite.rendering.transformator;

import ch.g_7.graphite.base.transform.IROTransform;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.IWindow;
import org.joml.Matrix4f;

public interface ITransformator {

	Matrix4f getProjectionMatrix(IWindow window, Camera camera);
	
	Matrix4f getModelViewMatrix(IROTransform transform);

}
