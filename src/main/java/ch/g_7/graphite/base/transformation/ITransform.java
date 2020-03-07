package ch.g_7.graphite.base.transformation;

import org.joml.Vector3fc;
import org.joml.Vector3ic;

public interface ITransform {

	Vector3fc getPosition();
	
	Vector3fc getRotation();
	
	Vector3fc getScale();
	
}
