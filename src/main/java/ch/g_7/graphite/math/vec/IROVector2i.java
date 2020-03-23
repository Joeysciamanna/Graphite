package ch.g_7.graphite.math.vec;

public interface IROVector2i {

	IVector2i add(int i, IVector2i des);
	
	IVector2i add(IROVector2i vec, IVector2i des);
	
	IVector2i add(int x, int y, IVector2i des);

	
	IVector2i sub(int i, IVector2i des);
	
	IVector2i sub(IROVector2i vec, IVector2i des);
	
	IVector2i sub(int x, int y, IVector2i des);
	
	
	IVector2i mul(int i, IVector2i des);
	
	IVector2i mul(IROVector2i vec, IVector2i des);
	
	IVector2i mul(int x, int y, IVector2i des);
	
	
	IVector2i div(int i, IVector2i des);
	
	IVector2i div(IROVector2i vec, IVector2i des);
	
	IVector2i div(int x, int y, IVector2i des);

	
	IVector2i max(int i, IVector2i des);
	
	IVector2i max(IROVector2i vec, IVector2i des);
	
	IVector2i max(int x, int y, IVector2i des);

	
	IVector2i min(int i, IVector2i des);
	
	IVector2i min(IROVector2i vec, IVector2i des);
	
	IVector2i min(int x, int y, IVector2i des);
	
	
	IVector2i rotate(float angle, IVector2i des);
	
	IVector2i rotate(IROVector2i vec, float angle, IVector2i des);

	IVector2i rotate(int x, int y, float angle, IVector2i des);
	
	
	float dot(IROVector2i vec);
	
	float dot(int x, int y);
	
	
	float angle(IROVector2i vec);
	
	float angle(int x, int y);
	
	
	float distance(IROVector2i vec);
	
	float distance(int x, int y);
	
	float distanceSq(IROVector2i vec);
	
	float distanceSq(int x, int y);
	
	int distanceX(int x);
	
	int distanceY(int y);
	
	
	float lenght();
	
	float lenghtSq();
	
	
	IVector3i transform3i(int z);
	
	IVector2f transform2f();
	
	IVector3f transform3f(float z);
	
	
	int getX();
	
	int getY();


	IVector2i clone();
	
	boolean equals(Object obj);
	
	String toString();
	
}
