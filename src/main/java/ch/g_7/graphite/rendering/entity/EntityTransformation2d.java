package ch.g_7.graphite.rendering.entity;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.Localizable;
import ch.g_7.graphite.rendering.ITransformation;

public class EntityTransformation2d implements ITransformation<Localizable> {

	private Matrix4f projectionMatrix;
	private Matrix4f modelViewMatrix;

	public EntityTransformation2d() {
			projectionMatrix = new Matrix4f();
			modelViewMatrix = new Matrix4f();
		}

	@Override
	public Matrix4f getProjectionMatrix(Window window, Camera camera) {
		return projectionMatrix.identity().translate((float) -camera.getPosition().x(),
				(float) -camera.getPosition().y(), (float) -camera.getPosition().z());
	}

	@Override
	public Matrix4f getModelViewMatrix(Localizable entity) {
		return modelViewMatrix.identity().translate(entity.getPosition()).rotateXYZ(new Vector3f(entity.getRotation()))
				.scale(entity.getScale());
	}

}
