package ch.g_7.graphite.rendering.transformator;

import ch.g_7.graphite.base.transform.IROTransform;
import org.joml.Matrix4f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;

public interface ITransformator {

	Matrix4f getProjectionMatrix(Window window, Camera camera);
	
	Matrix4f getModelViewMatrix(IROTransform transform);

}
