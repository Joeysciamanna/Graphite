package ch.g_7.graphite.math.vec;

import org.joml.Vector3f;

public interface IVector3f {

	IVector3f add(IVector3f vec);
	
	IVector3f add(float x, float y, float z);
	
	IVector3f sub(IVector3f vec);
	
	IVector3f sub(float x, float y, float z);
	
	IVector3f mul(IVector3f vec);
	
	IVector3f mul(float x, float y, float z);
	
	IVector3f div(IVector3f vec);
	
	IVector3f div(float x, float y, float z);
	
	IVector3f max(IVector3f vec);
	
	IVector3f max(float x, float y, float z);

	IVector3f min(IVector3f vec);
	
	IVector3f min(float x, float y, float z);
	
	
	float dot(IVector3f vec);
	
	float dot(float x, float y, float z);
	
	float angle(IVector3f vec);
	
	float angle(float x, float y, float z);
	
	float distance(IVector3f vec);
	
	float distance(float x, float y, float z);
			
	float distanceX(float x);
	
	float distanceY(float y);
	
	float distanceZ(float z);
	
	
	IVector3i transform3i();
	
	IVector2f transform2f();
	
	IVector2i transform2i();
	
	
	float getX();
	
	float getY();
	
	float getZ();
	
	IVector3f setX(float x);
	
	IVector3f setY(float y);
	
	IVector3f setZ(float z);
	
	IVector3f set(float x, float y, float z);
	
	IVector3f set(IVector3f vec);
	
	
	IVector3f clone();
	
	boolean equals(Object obj);
	
	String toString();
	
	
	
	/*
	 * rotate
	 * cross?
	 * reset
	 */

}
