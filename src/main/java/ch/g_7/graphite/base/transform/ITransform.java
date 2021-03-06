package ch.g_7.graphite.base.transform;

import org.joml.Vector3f;

public interface ITransform extends IROTransform {


	Vector3f getTranslation();

	void setTranslation(Vector3f translation);


	Vector3f getRotation();

	void setRotation(Vector3f translation);


	Vector3f getScale();

	void setScale(Vector3f scale);


	
}
