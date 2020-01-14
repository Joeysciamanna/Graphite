package ch.g_7.graphite.rendering.transformator;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.base.transformation.ITransformation;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;

public class OrthographicTransformator implements ITransformator<ITransformation> {

	private Matrix4f projectionMatrix;
	private Matrix4f modelViewMatrix;

	public OrthographicTransformator() {
			projectionMatrix = new Matrix4f();
			modelViewMatrix = new Matrix4f();
		}

	@Override
	public Matrix4f getProjectionMatrix(Window window, Camera camera) {
		return projectionMatrix.identity().translate((float) -camera.getPosition().x(),
				(float) -camera.getPosition().y(), (float) -camera.getPosition().z());
	}

	@Override
	public Matrix4f getModelViewMatrix(ITransformation transformation) {
		return modelViewMatrix.identity().translate(transformation.getPosition()).rotateXYZ(new Vector3f(transformation.getRotation()))
				.scale(transformation.getScale());
	}

}
