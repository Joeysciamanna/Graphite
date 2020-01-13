package ch.g_7.graphite.base.transformation;

import org.joml.Vector3f;

public class Transformation implements ITransformation {

	private Vector3f position;
	private Vector3f rotation;
	private Vector3f scale;
	
	@Override
	public Vector3f getPosition() {
		return position;
	}

	@Override
	public Vector3f getRotation() {
		return rotation;
	}

	@Override
	public Vector3f getScale() {
		return scale;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}
	
	public void setScale(Vector3f scale) {
		this.scale = scale;
	}

}
