package ch.g_7.graphite.base.transformation;

import org.joml.Vector3f;

public class Transform implements ITransform {

	private Vector3f position;
	private Vector3f rotation;
	private Vector3f scale;
	
	public Transform() {
		this.position = new Vector3f();
		this.rotation = new Vector3f();
		this.scale = new Vector3f(1,1,1);
	}

	public void translate(Vector3f v) {
		position.add(v);
	}
	
	public void translate(float x, float y, float z) {
		position.add(x, y, z);
	}

	@Override
	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	@Override
	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}
	
	@Override
	public Vector3f getScale() {
		return scale;
	}

	public void setScale(Vector3f scale) {
		this.scale = scale;
	}

}
