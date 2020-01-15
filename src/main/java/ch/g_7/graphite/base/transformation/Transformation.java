package ch.g_7.graphite.base.transformation;

import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector3ic;

public class Transformation implements ITransformation {

	private Vector3f position;
	private Vector3f rotation;
	private Vector3f scale;
	
	public Transformation() {
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

	@Override
	public Vector3ic getIntPosition() {
		return new Vector3i((int) position.x, (int) position.y, (int) position.z);
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
	
	@Override
	public Vector3ic getIntScale() {
		return new Vector3i((int) scale.x, (int) scale.y, (int) scale.z);
	}
	
	public void setScale(Vector3f scale) {
		this.scale = scale;
	}

}
