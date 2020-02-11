package ch.g_7.graphite.math.vec2;

import ch.g_7.graphite.math.vec3.IVector3f;
import ch.g_7.graphite.math.vec3.IVector3i;

public interface IROVector2i {

	IVector2i add(float i, IVector2i des);
	
	IVector2i add(IROVector2i vec, IVector2i des);
	
	IVector2i add(int x, int y, IVector2i des);

	
	IVector2i sub(float i, IVector2i des);
	
	IVector2i sub(IROVector2i vec, IVector2i des);
	
	IVector2i sub(int x, int y, IVector2i des);
	
	
	IVector2i mul(float i, IVector2i des);
	
	IVector2i mul(IROVector2i vec, IVector2i des);
	
	IVector2i mul(int x, int y, IVector2i des);
	
	
	IVector2i div(float i, IVector2i des);
	
	IVector2i div(IROVector2i vec, IVector2i des);
	
	IVector2i div(int x, int y, IVector2i des);

	
	IVector2i max(float i, IVector2i des);
	
	IVector2i max(IROVector2i vec, IVector2i des);
	
	IVector2i max(int x, int y, IVector2i des);

	
	IVector2i min(float i, IVector2i des);
	
	IVector2i min(IROVector2i vec, IVector2i des);
	
	IVector2i min(int x, int y, IVector2i des);
	
	
	IVector2i normalize(IVector2i des);
	
	IVector2i normalize(float len, IVector2i des);
	
	
	float dot(IROVector2i vec);
	
	float dot(int x, int y);
	
	float angle(IROVector2i vec);
	
	float angle(int x, int y);
	
	float distance(IROVector2i vec);
	
	float distance(int x, int y);
	
	int distanceX(int x);
	
	int distanceY(int y);
	
	
	IVector3i transform3i(int z);
	
	IVector2f transform2f();
	
	IVector3f transform3f(float z);
	
	
	int getX();
	
	int getY();


	IVector2i clone();
	
	boolean equals(Object obj);
	
	String toString();
	
}
