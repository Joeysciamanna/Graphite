package ch.g_7.graphite.entity.object;

import org.joml.Matrix4fc;
import org.joml.Vector3fc;

import ch.g_7.graphite.entity.viewmodel.IViewModel;
import ch.g_7.graphite.rendering.Renderable;

public interface IObject extends Renderable {

	IViewModel getViewModel();

	Vector3fc getPosition();

	Vector3fc getRotation();

	Matrix4fc getModelViewMatrix();

	float getScale();

}
