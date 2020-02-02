package ch.g_7.graphite.math.vec;

public interface IVector2i {

	IVector2i add(IVector2i vec);
	
	IVector2i add(int x, int y);
	
	IVector2i add(IVector2i vec, Vector2i des);
	
	IVector2i add(int x, int y, Vector2i des);
	
	
	IVector2i sub(IVector2i vec);
	
	IVector2i sub(int x, int y);
	
	IVector2i sub(IVector2i vec, Vector2i des);
	
	IVector2i sub(int x, int y, Vector2i des);
	
	
	IVector2i mul(IVector2i vec);
	
	IVector2i mul(int x, int y);
	
	IVector2i mul(IVector2i vec, Vector2i des);
	
	IVector2i mul(int x, int y, Vector2i des);
	
	
	IVector2i div(IVector2i vec);
	
	IVector2i div(int x, int y);
	
	IVector2i div(IVector2i vec, Vector2i des);
	
	IVector2i div(int x, int y, Vector2i des);
	
	
	IVector2i max(IVector2i vec);
	
	IVector2i max(int x, int y);
	
	IVector2i max(IVector2i vec, Vector2i des);
	
	IVector2i max(int x, int y, Vector2i des);
	

	IVector2i min(IVector2i vec);
	
	IVector2i min(int x, int y);
	
	IVector2i min(IVector2i vec, Vector2i des);
	
	IVector2i min(int x, int y, Vector2i des);
	
	
	float dot(IVector2i vec);
	
	float dot(int x, int y);
	
	float angle(IVector2i vec);
	
	float angle(int x, int y);
	
	float distance(IVector2i vec);
	
	float distance(int x, int y);
	
	int distanceX(int x);
	
	int distanceY(int y);
	
	
	IVector3i transform3i(int z);
	
	IVector2f transform2f();
	
	IVector3f transform3f(float z);
	
	
	int getX();
	
	int getY();
	
	IVector2i setX(int x);
	
	IVector2i setY(int y);
	
	IVector2i set(int x, int y);
	
	IVector2i set(IVector2i vec);
	
	
	IVector2i clone();
	
	boolean equals(Object obj);
	
	String toString();
}
