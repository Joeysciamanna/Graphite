package ch.g_7.graphite.rendering.transformator;

import ch.g_7.graphite.base.transform.IROTransform;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.IWindow;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class OrthographicTransformator implements ITransformator {

    private Matrix4f projectionMatrix;
    private Matrix4f modelViewMatrix;

    public OrthographicTransformator() {
        projectionMatrix = new Matrix4f();
        modelViewMatrix = new Matrix4f();
    }

    @Override
    public Matrix4f getProjectionMatrix(IWindow window, Camera camera) {
	return projectionMatrix.identity().translate(-camera.getTransform().getTranslation().x(),
			-camera.getTransform().getTranslation().y(), -camera.getTransform().getTranslation().z());
}

	@Override
	public Matrix4f getModelViewMatrix(IROTransform transform) {
		return modelViewMatrix.identity().translate(transform.getTranslation()).rotateXYZ(new Vector3f(transform.getRotation()))
				.scale(transform.getScale());
	}

}
