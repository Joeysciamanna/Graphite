package ch.g_7.graphite.core;

import ch.g_7.graphite.base.transform.Transform;

public class Camera {

	private Transform transform;
	
	public Camera() {
		this.transform = new Transform();
	}

	public Transform getTransform() {
		return transform;
	}

}
