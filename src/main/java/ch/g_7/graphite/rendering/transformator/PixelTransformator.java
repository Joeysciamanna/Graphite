package ch.g_7.graphite.rendering.transformator;

import ch.g_7.graphite.base.transform.IROTransform;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.IWindow;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector2ic;

public class PixelTransformator implements ITransformator {

	private Matrix4f projectionMatrix;
	private Matrix4f modelViewMatrix;
	
	private Vector2ic windowSize;
	private Vector2f cameraPosition;

	public PixelTransformator() {
		projectionMatrix = new Matrix4f();
		modelViewMatrix = new Matrix4f();
	}
	
	@Override
	public Matrix4f getProjectionMatrix(IWindow window, Camera camera) {
		windowSize = window.getSize();
		cameraPosition = new Vector2f(camera.getTransform().getTranslation().x, camera.getTransform().getTranslation().y);
		return projectionMatrix;
	}
	
	
	@Override
	public Matrix4f getModelViewMatrix(IROTransform transform) {
		return modelViewMatrix.identity()
				  .translate((transform.getTranslation().x()-cameraPosition.x) * 2f / windowSize.x() - 1f,
						     (transform.getTranslation().y()-cameraPosition.y) * -2f / windowSize.y() + 1f, -1)
				  .scaleXY(transform.getScale().x() * 2f / windowSize.x(), transform.getScale().y() * 2f / windowSize.y());
	}
}
