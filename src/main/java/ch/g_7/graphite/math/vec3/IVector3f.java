package ch.g_7.graphite.math.vec3;

public interface IVector3f extends IROVector3f {
	
	IVector3f add(float i);

	IVector3f add(IROVector3f vec);
	
	IVector3f add(float x, float y, float z);
	
	
	IVector3f sub(float i);
	
	IVector3f sub(IROVector3f vec);
	
	IVector3f sub(float x, float y, float z);
	
	
	IVector3f mul(float i);
	
	IVector3f mul(IROVector3f vec);
	
	IVector3f mul(float x, float y, float z);
	
	
	IVector3f div(float i);
	
	IVector3f div(IROVector3f vec);
	
	IVector3f div(float x, float y, float z);
	
	
	IVector3f max(float i);
	
	IVector3f max(IROVector3f vec);
	
	IVector3f max(float x, float y, float z);

	
	IVector3f min(float i);
	
	IVector3f min(IROVector3f vec);
	
	IVector3f min(float x, float y, float z);


	IVector3f normalize();
	
	IVector3f normalize(float len);
	

	IVector3f set(IROVector3f vec);

	IVector3f set(float x, float y, float z);

	IVector3f setX(float x);
	
	IVector3f setY(float y);
	
	IVector3f setZ(float z);
	
	


	
//	default void test() {
//		org.joml.Vector3f vector3f;
//		org.joml.Vector2f vector2f;
//		vector3f.normalize()
//	}
	
	/*
	 * TODO
	 * lerp (liniar iterpolation)
	 * distanceSquared
	 * lenghtSquared
	 * rotate (Quaternion n stuff
	 * cross (dot similar thing) (3d only)
	 * lenght (|v|) ~
	 * 
	 * 
	 */

}
