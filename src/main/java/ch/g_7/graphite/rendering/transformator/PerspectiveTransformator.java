package ch.g_7.graphite.rendering.transformator;

import ch.g_7.graphite.base.transformation.IROTransform;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.base.transformation.ITransform;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;

public class PerspectiveTransformator implements ITransformator {

	private float fov = (float) Math.toRadians(90.0f);

	private float zNear = 0.01f;

	private float zFar = 1000.f;

	private Matrix4f projectionMatrix;
	private Matrix4f modelViewMatrix;
	private Matrix4f viewMatrix;

	public PerspectiveTransformator() {
		projectionMatrix = new Matrix4f();
		modelViewMatrix = new Matrix4f();
		viewMatrix = new Matrix4f();
	}

	@Override
	public Matrix4f getProjectionMatrix(Window window, Camera camera) {
		viewMatrix.identity().translate((float) -camera.getTransform().getTranslation().x(), (float) -camera.getTransform().getTranslation().y(),
				(float) -camera.getTransform().getTranslation().z());
		return projectionMatrix.identity().perspective(fov, (float) window.getWidth() / window.getHeight(), zNear, zFar).mul(viewMatrix);
	}

	@Override
	public Matrix4f getModelViewMatrix(IROTransform transform) {
		return modelViewMatrix.identity().identity().translate(transform.getTranslation())
				.rotateXYZ(new Vector3f(transform.getRotation())).scale(transform.getScale());
	}

}
