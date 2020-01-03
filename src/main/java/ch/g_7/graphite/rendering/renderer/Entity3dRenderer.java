package ch.g_7.graphite.rendering.renderer;

import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.shaderprogram.EntityShaderProgram;

public class Entity3dRenderer extends BasicRenderer<EntityShaderProgram, IEntity> implements ITransformation<IEntity> {

	private final Matrix4f projectionMatrix;

	private final Matrix4f modelViewMatrix;

	private float fov = (float) Math.toRadians(60.0f);

	private float zNear = 0.01f;

	private float zFar = 1000.f;

	public Entity3dRenderer() {
		super(new EntityShaderProgram());
		projectionMatrix = new Matrix4f();
		modelViewMatrix = new Matrix4f();
	}

	@Override
	protected void renderAll(List<IEntity> renderables) {
		for (IEntity entity : renderables) {
			render(entity, this);
		}
	}

	@Override
	protected void prepareTransformations(Window window, Camera camera) {
		prepareTransformation(window, camera);
	}

	@Override
	public Matrix4f getModelViewMatrix(IEntity entity) {
		return modelViewMatrix.translate(entity.getPosition()).rotateXYZ(new Vector3f(entity.getRotation()))
				.scale(entity.getScale()).mul(projectionMatrix);
	}

	@Override
	public void prepareTransformation(Window window, Camera camera) {
		projectionMatrix.identity();
		projectionMatrix.perspective(fov, window.getWidth() / window.getHeight(), zNear, zFar);
	}

	public void setFov(float fov) {
		this.fov = fov;
	}

	public void setzFar(float zFar) {
		this.zFar = zFar;
	}

	public void setzNear(float zNear) {
		this.zNear = zNear;
	}

}