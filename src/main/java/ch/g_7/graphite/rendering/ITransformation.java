package ch.g_7.graphite.rendering;

import org.joml.Matrix4f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;

public interface ITransformation<R extends Renderable> {


	Matrix4f getModelViewMatrix(R r);

	void prepareTransformation(Window window, Camera camera);
}
