package ch.g_7.graphite.math.vec;

public interface IVector2f {

	
	IVector2f add(IVector2f vec);
	
	IVector2f add(float x, float y);
	
	IVector2f sub(IVector2f vec);
	
	IVector2f sub(float x, float y);
	
	IVector2f mul(IVector2f vec);
	
	IVector2f mul(float x, float y);
	
	IVector2f div(IVector2f vec);
	
	IVector2f div(float x, float y);
	
	IVector2f max(IVector2f vec);
	
	IVector2f max(float x, float y);

	IVector2f min(IVector2f vec);
	
	IVector2f min(float x, float y);
	
	
	float dot(IVector2f vec);
	
	float dot(float x, float y);
	
	float angle(IVector2f vec);
	
	float angle(float x, float y);
	
	float distance(IVector2f vec);
	
	float distance(float x, float y);
	
	float distanceX(float x);
	
	float distanceY(float y);
	
	
	IVector3f transform3f(float z);
	
	IVector3i transform3i(int z);
	
	IVector2i transform2i();
	
	
	float getX();
	
	float getY();
	
	IVector2f setX(float x);
	
	IVector2f setY(float y);
	
	IVector2f set(float x, float y);
	
	IVector2f set(IVector2f vec);
	
	
	IVector2f clone();
	
	boolean equals(Object obj);
	
	String toString();

	
	
}
