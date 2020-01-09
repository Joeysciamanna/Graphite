package ch.g_7.graphite.rendering.ui;

import org.joml.Matrix4f;
import org.joml.Vector2ic;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.ui.IUIPanel;

public class UITransformation implements ITransformation<IUIPanel>{

	private Matrix4f projectionMatrix;
	private Matrix4f modelViewMatrix;
	
	private Vector2ic windowSize;
	
	public UITransformation() {
		projectionMatrix = new Matrix4f();
		modelViewMatrix = new Matrix4f();
	}
	
	@Override
	public Matrix4f getProjectionMatrix(Window window, Camera camera) {
		windowSize = window.getSize();
		return projectionMatrix;
	}
	
	
	@Override
	public Matrix4f getModelViewMatrix(IUIPanel panel) {
		return modelViewMatrix.identity()
				  .translate(panel.getPosition().x() * 2f / windowSize.x() - 1f, panel.getPosition().y() * -2f / windowSize.y() + 1f, -1)
				  .scaleXY(panel.getSize().x() * 2f / windowSize.x(), panel.getSize().y() * 2f / windowSize.y());
	}
}
