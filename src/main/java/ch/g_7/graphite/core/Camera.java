package ch.g_7.graphite.core;

import org.joml.Vector3d;
import org.joml.Vector3dc;

public class Camera {

	private Vector3d position;
	
	public Camera() {
		this.position = new Vector3d();
	}
	
	public Vector3dc getPosition() {
		return position;
	}
	
}
