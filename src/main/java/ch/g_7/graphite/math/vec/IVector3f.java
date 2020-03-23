package ch.g_7.graphite.math.vec;

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

	
	IVector3f cross(IROVector3f vec);
	
	IVector3f cross(float x, float y, float z);


	IVector3f normalize();
	
	IVector3f normalize(float len);

	
	IVector3f rotate(IROVector3f vec, float angle);
	
	IVector3f rotate(float x, float y, float z, float angle);
	
	IVector3f rotateX(float angle);
	
	IVector3f rotateY(float angle);
	
	IVector3f rotateZ(float angle);
	
	
	IVector3f set(IROVector3f vec);

	IVector3f set(float x, float y, float z);

	IVector3f setX(float x);
	
	IVector3f setY(float y);
	
	IVector3f setZ(float z);
	
	


	
//	default void test() {
//		org.joml.Vector3f vector3f;
//		org.joml.Vector2f vector2f;
//		org.joml.Matrix2d matrix2d;
//	}	
	
	/*
	 * TODO
	 * rotate (Quaternion n stuff
	 * 
	 */

}
