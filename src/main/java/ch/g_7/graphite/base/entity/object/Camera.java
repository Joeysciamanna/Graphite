package ch.g_7.graphite.base.entity.object;

import org.joml.Vector3d;

public class Camera {

	private Vector3d position;
	
	public Camera() {
		this.position = new Vector3d();
	}
	
	public Vector3d getPosition() {
		return position;
	}
	
}
