package ch.g_7.graphite.base.transformation;

import org.joml.Vector2f;
import org.joml.Vector2fc;

public class Transformation2d extends Transformation {

	public Transformation2d(float z) {
		getPosition().z = z;
	}
	
	public Transformation2d() {}
	
	public Vector2f getLocation() {
		return new Vector2f(getPosition().x, getPosition().y);
	}
	
	public void setLocation(Vector2fc location) {
		getPosition().set(location, getPosition().z);
	}

}
