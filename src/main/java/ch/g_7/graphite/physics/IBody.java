package ch.g_7.graphite.physics;

import java.util.List;

import org.joml.Vector3fc;

public interface IBody {

	
	void move(Vector3fc distance);
	
	float getBounceMultiplyer();
	
	float getWeight();
	
	float addForce();
	
	float getForce();
	
	float setForce();
	
	List<Vector3fc> getPoints();
	
	Vector3fc getCenterOfMass();
	
}
