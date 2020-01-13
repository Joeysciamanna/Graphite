package ch.g_7.graphite.rendering.transformator;

import org.joml.Matrix4f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;

public interface ITransformator<R> {

	Matrix4f getProjectionMatrix(Window window, Camera camera);
	
	Matrix4f getModelViewMatrix(R r);

}
