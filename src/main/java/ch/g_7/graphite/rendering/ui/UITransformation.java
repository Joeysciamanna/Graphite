package ch.g_7.graphite.rendering.ui;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.ui.IUIPanel;

public class UITransformation implements ITransformation<IUIPanel>{

	private Matrix4f projectionMatrix;
	private Matrix4f modelViewMatrix;
	
	public UITransformation() {
		projectionMatrix = new Matrix4f();
		modelViewMatrix = new Matrix4f();
	}
	
	@Override
	public Matrix4f getProjectionMatrix(Window window, Camera camera) {
		return projectionMatrix;
	}
	
	@Override
	public Matrix4f getModelViewMatrix(IUIPanel panel) {
		return modelViewMatrix.identity()
				  .translate(new Vector3f(panel.getPosition().x() - 1 , panel.getPosition().y()*-1 + 1, -1))
				  .scaleXY(panel.getSize().x(), panel.getSize().y());
	}
}
