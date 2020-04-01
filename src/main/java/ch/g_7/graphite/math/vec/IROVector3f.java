package ch.g_7.graphite.math.vec;

public interface IROVector3f {

	
	IVector3f add(float i, IVector3f des);
	
	IVector3f add(IROVector3f vec, IVector3f des);
	
	IVector3f add(float x, float y, float z, IVector3f des);
	
	
	IVector3f sub(float i, IVector3f des);
	
	IVector3f sub(IROVector3f vec, IVector3f des);
	
	IVector3f sub(float x, float y, float z, IVector3f des);
	
	
	IVector3f mul(float i, IVector3f des);
	
	IVector3f mul(IROVector3f vec, IVector3f des);
	
	IVector3f mul(float x, float y, float z, IVector3f des);
	
	
	IVector3f div(float i, IVector3f des);
	
	IVector3f div(IROVector3f vec, IVector3f des);
	
	IVector3f div(float x, float y, float z, IVector3f des);
	
	
	IVector3f max(float i, IVector3f des);
	
	IVector3f max(IROVector3f vec, IVector3f des);
	
	IVector3f max(float x, float y, float z, IVector3f des);
	
	
	IVector3f min(float i, IVector3f des);
	
	IVector3f min(IROVector3f vec, IVector3f des);
	
	IVector3f min(float x, float y, float z, IVector3f des);
	
	
	IVector3f cross(IROVector3f vec, IVector3f des);
	
	IVector3f cross(float x, float y, float z, IVector3f des);
	
	
	IVector3f normalize(IVector3f des);
	
	IVector3f normalize(float len, IVector3f des);

	
	IVector3f rotateX(float angle, IVector3f des);
	
	IVector3f rotateY(float angle, IVector3f des);
	
	IVector3f rotateZ(float angle, IVector3f des);
	
	
	float dot(IROVector3f vec);
	
	float dot(float x, float y, float z);
	
	
	float angle(IROVector3f vec);
	
	float angle(float x, float y, float z);
	
	
	float distance(IROVector3f vec);
	
	float distance(float x, float y, float z);
			
	float distanceSq(IROVector3f vec);
	
	float distanceSq(float x, float y, float z);
	
	float distanceX(float x);
	
	float distanceY(float y);
	
	float distanceZ(float z);
	
	
	float lenght();

	float lenghtSq();
	
	
	IVector3i transform3i();
	
	IVector2f transform2f();
	
	IVector2i transform2i();
	
	
	float getX();
	
	float getY();
	
	float getZ();
	
	
	IVector3f clone();
	
	boolean equals(Object obj);
	
	String toString();
	

}
