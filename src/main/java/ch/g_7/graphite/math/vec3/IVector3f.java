package ch.g_7.graphite.math.vec3;

public interface IVector3f extends IROVector3f {
	

	IVector3f add(IROVector3f vec);
	
	IVector3f add(float x, float y, float z);
	
	
	IVector3f sub(IROVector3f vec);
	
	IVector3f sub(float x, float y, float z);
	
	
	IVector3f mul(IROVector3f vec);
	
	IVector3f mul(float x, float y, float z);
	
	
	IVector3f div(IROVector3f vec);
	
	IVector3f div(float x, float y, float z);
	
	
	IVector3f max(IROVector3f vec);
	
	IVector3f max(float x, float y, float z);

	
	IVector3f min(IROVector3f vec);
	
	IVector3f min(float x, float y, float z);



	IVector3f set(IROVector3f vec);

	IVector3f set(float x, float y, float z);

	IVector3f setX(float x);
	
	IVector3f setY(float y);
	
	IVector3f setZ(float z);
	
	


	
//	default void test() {
//		org.joml.Vector3f vector3f;
//		org.joml.Vector2f vector2f;
//		vector3f
//		      vector3f.rotateAxis(angle, x, y, z)
//				vector3f.rotateX(angle)
//	}
	
	/*
	 * TODO
	 * normalize (xyz^2 = 1)
	 * rotate (Quaternion n stuff
	 * cross (dot similar thing)
	 * lenght (|v|)
	 * scale (multiply / divide by one value)
	 * 
	 * 
	 */

}
