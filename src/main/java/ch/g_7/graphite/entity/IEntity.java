package ch.g_7.graphite.entity;

import org.joml.Vector3fc;

import ch.g_7.graphite.rendering.BasicRenderable;

public interface IEntity extends BasicRenderable {

	Vector3fc getPosition();

	Vector3fc getRotation();

	float getScale();

}
