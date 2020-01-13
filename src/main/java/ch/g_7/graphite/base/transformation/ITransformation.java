package ch.g_7.graphite.base.transformation;

import org.joml.Vector3fc;

public interface ITransformation {

	Vector3fc getPosition();
	
	Vector3fc getRotation();
	
	Vector3fc getScale();
}
