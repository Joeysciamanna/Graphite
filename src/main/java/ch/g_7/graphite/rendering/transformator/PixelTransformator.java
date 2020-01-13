package ch.g_7.graphite.rendering.transformator;

import org.joml.Matrix4f;
import org.joml.Vector2ic;

import ch.g_7.graphite.base.transformation.ITransformation;
import ch.g_7.graphite.base.transformation.Transformation;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.IUIPanel;

public class PixelTransformator implements ITransformator<ITransformation>{

	private Matrix4f projectionMatrix;
	private Matrix4f modelViewMatrix;
	
	private Vector2ic windowSize;
	
	public PixelTransformator() {
		projectionMatrix = new Matrix4f();
		modelViewMatrix = new Matrix4f();
	}
	
	@Override
	public Matrix4f getProjectionMatrix(Window window, Camera camera) {
		windowSize = window.getSize();
		return projectionMatrix;
	}
	
	
	@Override
	public Matrix4f getModelViewMatrix(ITransformation transformation) {
		return modelViewMatrix.identity()
				  .translate(transformation.getPosition().x() * 2f / windowSize.x() - 1f, transformation.getPosition().y() * -2f / windowSize.y() + 1f, -1)
				  .scaleXY(transformation.getScale().x() * 2f / windowSize.x(), transformation.getScale().y() * 2f / windowSize.y());
	}
}
