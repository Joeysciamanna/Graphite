package ch.g_7.graphite.physics2d;

import java.util.List;

import org.joml.Rectangled;
import org.joml.Vector2d;

public interface IBody {

	Rectangled getBounds();
	
	List<Vector2d> getPoints();
	
	Vector2d getCenterOfMass();
	
	float getMass();
	
	void onCollision(Vector2d point, IBody object, Vector2d otherPoint);
	
	
}
