package ch.g_7.graphite.rendering.transformator;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector2ic;

import ch.g_7.graphite.base.transformation.ITransform;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;

public class PixelTransformator implements ITransformator<ITransform>{

	private Matrix4f projectionMatrix;
	private Matrix4f modelViewMatrix;
	
	private Vector2ic windowSize;
	private Vector2f cameraPosition;

	public PixelTransformator() {
		projectionMatrix = new Matrix4f();
		modelViewMatrix = new Matrix4f();
	}
	
	@Override
	public Matrix4f getProjectionMatrix(Window window, Camera camera) {
		windowSize = window.getSize();
		cameraPosition = new Vector2f(camera.getPosition().x, camera.getPosition().y);
		return projectionMatrix;
	}
	
	
	@Override
	public Matrix4f getModelViewMatrix(ITransform transformation) {
		return modelViewMatrix.identity()
				  .translate((transformation.getPosition().x()-cameraPosition.x) * 2f / windowSize.x() - 1f,
						     (transformation.getPosition().y()-cameraPosition.y) * -2f / windowSize.y() + 1f, -1)
				  .scaleXY(transformation.getScale().x() * 2f / windowSize.x(), transformation.getScale().y() * 2f / windowSize.y());
	}
}
