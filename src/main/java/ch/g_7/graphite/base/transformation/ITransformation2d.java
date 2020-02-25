package ch.g_7.graphite.base.transformation;

import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3fc;

public interface ITransformation2d extends ITransformation {

	Vector2fc getPosition2d();
	
	Vector2ic getIntPosition2d();
	
	Vector3fc getRotation();
	
	Vector2fc getScale2d();
	
	Vector2ic getIntScale2d();
}
