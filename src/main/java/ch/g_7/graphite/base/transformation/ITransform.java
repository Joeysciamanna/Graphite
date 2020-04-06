package ch.g_7.graphite.base.transformation;

import ch.g_7.graphite.math.vec.IVector3f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public interface ITransform extends IROTransform {


	Vector3f getTranslation();

	void setTranslation(Vector3f translation);


	Vector3f getRotation();

	void setRotation(Vector3f translation);


	Vector3f getScale();

	void setScale(Vector3f scale);


	
}
