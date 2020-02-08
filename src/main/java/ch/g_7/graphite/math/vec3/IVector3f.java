package ch.g_7.graphite.math.vec3;

import org.joml.Vector3i;

import ch.g_7.graphite.math.vec2.Vector2f;
import ch.g_7.graphite.math.vec2.Vector2i;

public interface IVector3f {

	IVector3f add(IVector3f vec);
	
	IVector3f add(float x, float y, float z);
	
	IVector3f add(IVector3f vec, Vector3f des);
	
	IVector3f add(float x, float y, float z, Vector3f des);
	
	
	IVector3f sub(IVector3f vec);
	
	IVector3f sub(float x, float y, float z);

	IVector3f sub(IVector3f vec, Vector3f des);
	
	IVector3f sub(float x, float y, float z, Vector3f des);
	
	
	IVector3f mul(IVector3f vec);
	
	IVector3f mul(float x, float y, float z);

	IVector3f mul(IVector3f vec, Vector3f des);
	
	IVector3f mul(float x, float y, float z, Vector3f des);
	
	
	IVector3f div(IVector3f vec);
	
	IVector3f div(float x, float y, float z);

	IVector3f div(IVector3f vec, Vector3f des);
	
	IVector3f div(float x, float y, float z, Vector3f des);
	
	
	IVector3f max(IVector3f vec);
	
	IVector3f max(float x, float y, float z);

	IVector3f max(IVector3f vec, Vector3f des);
	
	IVector3f max(float x, float y, float z, Vector3f des);

	
	IVector3f min(IVector3f vec);
	
	IVector3f min(float x, float y, float z);

	IVector3f min(IVector3f vec, Vector3f des);
	
	IVector3f min(float x, float y, float z, Vector3f des);
	
	
	float dot(IVector3f vec);
	
	float dot(float x, float y, float z);
	
	float angle(IVector3f vec);
	
	float angle(float x, float y, float z);
	
	float distance(IVector3f vec);
	
	float distance(float x, float y, float z);
			
	float distanceX(float x);
	
	float distanceY(float y);
	
	float distanceZ(float z);
	
	
	Vector3i transform3i();
	
	Vector2f transform2f();
	
	Vector2i transform2i();
	
	
	float getX();
	
	float getY();
	
	float getZ();

	IVector3f set(IVector3f vec);

	IVector3f set(float x, float y, float z);

	IVector3f setX(float x);
	
	IVector3f setY(float y);
	
	IVector3f setZ(float z);
	
	
	IVector3f clone();
	
	boolean equals(Object obj);
	
	String toString();

	
	default void test() {
		org.joml.Vector3f vector3f;
		org.joml.Vector2f vector2f;
		//      vector3f.rotateAxis(angle, x, y, z)
		//		vector3f.rotateX(angle)
	}
	
	/*
	 * rotate
	 * cross?
	 * reset
	 */

}
