package ch.g_7.graphite.base.transformation;

import org.joml.Vector3f;

public class Transform implements ITransform {

	private Vector3f translation;
	private Vector3f rotation;
	private Vector3f scale;
	
	public Transform() {
		this.translation = new Vector3f();
		this.rotation = new Vector3f();
		this.scale = new Vector3f(1,1,1);
	}

	public void translate(Vector3f v) {
		translation.add(v);
	}
	
	public void translate(float x, float y, float z) {
		translation.add(x, y, z);
	}

	@Override
	public Vector3f getTranslation() {
		return translation;
	}

	@Override
	public void setTranslation(Vector3f translation) {
		this.translation = translation;
	}

	@Override
	public Vector3f getRotation() {
		return rotation;
	}

	@Override
	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	@Override
	public Vector3f getScale() {
		return scale;
	}

	@Override
	public void setScale(Vector3f scale) {
		this.scale = scale;
	}
}
