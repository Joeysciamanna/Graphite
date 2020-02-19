package ch.g_7.graphite.core;

import org.joml.Vector3f;

public class Camera {

	private Vector3f position;
	
	public Camera() {
		this.position = new Vector3f();
	}
	
	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

}
