package ch.g_7.graphite.base.object;

import ch.g_7.graphite.util.Pos3d;

public class Camera {

	private Pos3d position;
	
	public Camera() {
		this.position = new Pos3d();
	}
	
	
	public Pos3d getPosition() {
		return position;
	}
	
}
