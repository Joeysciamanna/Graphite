package ch.g_7.graphite.base.transformation;

import org.joml.Vector3fc;
import org.joml.Vector3ic;

public interface ITransformation {

	Vector3fc getPosition();
	
	Vector3ic getIntPosition();
	
	Vector3fc getRotation();
	
	Vector3fc getScale();
	
	Vector3ic getIntScale();
	
}
