package ch.g_7.graphite.math.vec2;

public interface IVector2f extends IROVector2f {

	IVector2f add(IROVector2f vec);

	IVector2f add(float x, float y);
	

	IVector2f sub(IROVector2f vec);

	IVector2f sub(float x, float y);
	

	IVector2f mul(IROVector2f vec);

	IVector2f mul(float x, float y);

	
	IVector2f div(IROVector2f vec);

	IVector2f div(float x, float y);
	

	IVector2f max(IROVector2f vec);

	IVector2f max(float x, float y);

	
	IVector2f min(IROVector2f vec);

	IVector2f min(float x, float y);


	IVector2f set(IROVector2f vec);

	IVector2f set(float x, float y);

	IVector2f setX(float x);

	IVector2f setY(float y);

}
