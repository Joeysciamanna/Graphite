package ch.g_7.graphite.rendering.entity;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.BasicEntity;
import ch.g_7.graphite.rendering.ITransformation;

public class EntityTransformation3d implements ITransformation<BasicEntity> {

	private float fov = (float) Math.toRadians(90.0f);

	private float zNear = 0.01f;

	private float zFar = 1000.f;

	private Matrix4f projectionMatrix;
	private Matrix4f modelViewMatrix;
	private Matrix4f viewMatrix;

	public EntityTransformation3d() {
		projectionMatrix = new Matrix4f();
		modelViewMatrix = new Matrix4f();
		viewMatrix = new Matrix4f();
	}

	@Override
	public Matrix4f getProjectionMatrix(Window window, Camera camera) {
		viewMatrix.identity().translate((float) -camera.getPosition().x(), (float) -camera.getPosition().y(),
				(float) -camera.getPosition().z());
		return projectionMatrix.identity().perspective(fov, window.getWidth() / window.getHeight(), zNear, zFar);
	}

	@Override
	public Matrix4f getModelViewMatrix(BasicEntity entity) {
		return modelViewMatrix.identity().identity().translate(entity.getPosition())
				.rotateXYZ(new Vector3f(entity.getRotation())).scale(entity.getScale()).mul(viewMatrix);
	}

}
