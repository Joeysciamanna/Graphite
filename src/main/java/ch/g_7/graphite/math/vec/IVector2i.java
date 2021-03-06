package ch.g_7.graphite.math.vec;

public interface IVector2i extends IROVector2i {

	IVector2i add(int i);
	
	IVector2i add(IROVector2i vec);
	
	IVector2i add(int x, int y);

	
	IVector2i sub(int i);
	
	IVector2i sub(IROVector2i vec);
	
	IVector2i sub(int x, int y);
	

	IVector2i mul(int i);
	
	IVector2i mul(IROVector2i vec);
	
	IVector2i mul(int x, int y);
	

	IVector2i div(int i);
	
	IVector2i div(IROVector2i vec);
	
	IVector2i div(int x, int y);
	

	IVector2i max(int i);
	
	IVector2i max(IROVector2i vec);
	
	IVector2i max(int x, int y);
	

	IVector2i min(int i);
	
	IVector2i min(IROVector2i vec);
	
	IVector2i min(int x, int y);
	
	
	IVector2i rotate(float angle);
	
	IVector2i rotate(IROVector2i vec, float angle);
	
	IVector2i rotate(int x, int y, float angle);
	
	
	IVector2i set(IROVector2i vec);

	IVector2i set(int x, int y);

	IVector2i setX(int x);
	
	IVector2i setY(int y);
	
}
