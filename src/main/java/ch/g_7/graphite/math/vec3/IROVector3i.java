package ch.g_7.graphite.math.vec3;

import ch.g_7.graphite.math.vec2.IVector2f;
import ch.g_7.graphite.math.vec2.IVector2i;

public interface IROVector3i {

	IVector3i add(int i, IVector3i des);
	
	IVector3i add(IROVector3i vec, IVector3i des);

	IVector3i add(int x, int y, int z, IVector3i des);

	
	IVector3i sub(int i, IVector3i des);
	
	IVector3i sub(IROVector3i vec, IVector3i des);

	IVector3i sub(int x, int y, int z, IVector3i des);

	
	IVector3i mul(int i, IVector3i des);
	
	IVector3i mul(IROVector3i vec, IVector3i des);

	IVector3i mul(int x, int y, int z, IVector3i des);

	
	IVector3i div(int i, IVector3i des);
	
	IVector3i div(IROVector3i vec, IVector3i des);

	IVector3i div(int x, int y, int z, IVector3i des);

	
	IVector3i max(int i, IVector3i des);
	
	IVector3i max(IROVector3i vec, IVector3i des);

	IVector3i max(int x, int y, int z, IVector3i des);

	
	IVector3i min(int i, IVector3i des);
	
	IVector3i min(IROVector3i vec, IVector3i des);

	IVector3i min(int x, int y, int z, IVector3i des);
	
	
	IVector3i cross(IROVector3i vec, IVector3i des);
	
	IVector3i cross(int x, int y, int z, IVector3i des);
	
	
	float dot(IROVector3i vec);

	float dot(int x, int y, int z);

	
	float angle(IROVector3i vec);

	float angle(int x, int y, int z);

	
	float distance(IROVector3i vec);

	float distance(int x, int y, int z);

	float distanceSq(IROVector3i vec);

	float distanceSq(int x, int y, int z);

	int distanceX(int x);

	int distanceY(int y);

	int distanceZ(int z);

	
	float lenght();
	
	float lenghtSq();
	
	
	IVector3f transform3f();

	IVector2f transform2f();

	IVector2i transform2i();

	
	int getX();

	int getY();

	int getZ();

	
	IVector3i clone();

	boolean equals(Object obj);

	String toString();

}
