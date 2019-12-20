package ch.g_7.graphite.entity2d;

import org.joml.Vector3fc;

import ch.g_7.graphite.rendering.Basic2dRenderable;

public interface IEntity extends Basic2dRenderable {

	Vector3fc getPosition();

	Vector3fc getRotation();

	float getScale();

}
