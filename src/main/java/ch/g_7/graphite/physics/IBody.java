package ch.g_7.graphite.physics;

import org.joml.Vector3fc;

public interface IBody {

	Vector3fc getPosition();
	
	void move(Vector3fc distance);
	
	
}
