package ch.g_7.graphite.base.entity;

import org.joml.Matrix4fc;
import org.joml.Vector3fc;

import ch.g_7.graphite.base.viewmodel.IViewModel;
import ch.g_7.graphite.rendering.Renderable;

public interface IEntity extends Renderable {

	IViewModel getViewModel();

	Vector3fc getPosition();

	Vector3fc getRotation();

	Matrix4fc getModelViewMatrix();

	float getScale();

}
