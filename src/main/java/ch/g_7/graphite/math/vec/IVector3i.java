package ch.g_7.graphite.math.vec;

public interface IVector3i extends IROVector3i {

	IVector3i add(int i);
	
    IVector3i add(IROVector3i vec);

    IVector3i add(int x, int y, int z);

    
    IVector3i sub(int i);

    IVector3i sub(IROVector3i vec);

    IVector3i sub(int x, int y, int z);


    IVector3i mul(int i);
    
    IVector3i mul(IROVector3i vec);

    IVector3i mul(int x, int y, int z);


    IVector3i div(int i);
    
    IVector3i div(IROVector3i vec);

    IVector3i div(int x, int y, int z);

    
    IVector3i max(int i);

    IVector3i max(IROVector3i vec);

    IVector3i max(int x, int y, int z);


    IVector3i min(int i);
    
    IVector3i min(IROVector3i vec);

    IVector3i min(int x, int y, int z);

    
    IVector3i cross(IROVector3i vec);
	
    IVector3i cross(int x, int y, int z);
	
    
	IVector3i rotate(IROVector3i vec, float angle);
	
    IVector3i rotate(int x, int y, int z, float angle);
	
	IVector3i rotateX(float angle);
	
	IVector3i rotateY(float angle);
	
	IVector3i rotateZ(float angle);
	
	
    IVector3i set(IROVector3i vec);

    IVector3i set(int x, int y, int z);

    IVector3i setX(int x);

    IVector3i setY(int y);

    IVector3i setZ(int z);

    
}
