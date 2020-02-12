package ch.g_7.graphite.math.vec2;

import ch.g_7.graphite.math.vec3.IVector3f;
import ch.g_7.graphite.math.vec3.IVector3i;

public interface IROVector2f {

	IVector2f add(float i, IVector2f des);
	
	IVector2f add(IROVector2f vec, IVector2f des);

	IVector2f add(float x, float y, IVector2f des);
	
	
	IVector2f sub(float i, IVector2f des);

	IVector2f sub(IROVector2f vec, IVector2f des);

	IVector2f sub(float x, float y, IVector2f des);


	IVector2f mul(float i, IVector2f des);
	
	IVector2f mul(IROVector2f vec, IVector2f des);

	IVector2f mul(float x, float y, IVector2f des);

	
	IVector2f div(float i, IVector2f des);
	
	IVector2f div(IROVector2f vec, IVector2f des);

	IVector2f div(float x, float y, IVector2f des);


	IVector2f max(float i, IVector2f des);
	
	IVector2f max(IROVector2f vec, IVector2f des);

	IVector2f max(float x, float y, IVector2f des);

	
	IVector2f min(float i, IVector2f des);
	
	IVector2f min(IROVector2f vec, IVector2f des);

	IVector2f min(float x, float y, IVector2f des);
	

	IVector2f normalize(IVector2f des);
	
	IVector2f normalize(float len, IVector2f des);
	
	
	IVector2f rotate(float angle, IVector2f des);
	
	IVector2f rotate(IROVector2f vec, float angle, IVector2f des);
	
	IVector2f rotate(float x, float y, float angle, IVector2f des);
	
	
	float dot(IROVector2f vec);

	float dot(float x, float y);

	
	float angle(IROVector2f vec);

	float angle(float x, float y);

	
	float distance(IROVector2f vec);

	float distance(float x, float y);

	float distanceSq(IROVector2f vec);

	float distanceSq(float x, float y);

	float distanceX(float x);

	float distanceY(float y);

	
	float lenght();
	
	float lenghtSq();
	
	
	IVector3f transform3f(float z);

	IVector3i transform3i(int z);

	IVector2i transform2i();
	

	float getX();

	float getY();


	IVector2f clone();

	boolean equals(Object obj);

	String toString();
}
