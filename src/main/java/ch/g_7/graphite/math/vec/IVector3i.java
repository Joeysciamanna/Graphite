package ch.g_7.graphite.math.vec;

public interface IVector3i {

    IVector3i add(IVector3i vec);

    IVector3i add(int x, int y, int z);

    IVector3i add(IVector3i vec, Vector3i des);

    IVector3i add(int x, int y, int z, Vector3i des);


    IVector3i sub(IVector3i vec);

    IVector3i sub(int x, int y, int z);

    IVector3i sub(IVector3i vec, Vector3i des);

    IVector3i sub(int x, int y, int z, Vector3i des);


    IVector3i mul(IVector3i vec);

    IVector3i mul(int x, int y, int z);

    IVector3i mul(IVector3i vec, Vector3i des);

    IVector3i mul(int x, int y, int z, Vector3i des);


    IVector3i div(IVector3i vec);

    IVector3i div(int x, int y, int z);

    IVector3i div(IVector3i vec, Vector3i des);

    IVector3i div(int x, int y, int z, Vector3i des);


    IVector3i max(IVector3i vec);

    IVector3i max(int x, int y, int z);

    IVector3i max(IVector3i vec, Vector3i des);

    IVector3i max(int x, int y, int z, Vector3i des);


    IVector3i min(IVector3i vec);

    IVector3i min(int x, int y, int z);

    IVector3i min(IVector3i vec, Vector3i des);

    IVector3i min(int x, int y, int z, Vector3i des);


    float dot(IVector3i vec);

    float dot(int x, int y, int z);

    float angle(IVector3i vec);

    float angle(int x, int y, int z);

    float distance(IVector3i vec);

    float distance(int x, int y, int z);

    int distanceX(int x);

    int distanceY(int y);

    int distanceZ(int z);


    Vector3f transform3f();

    Vector2f transform2f();

    Vector2i transform2i();


    int getX();

    int getY();

    int getZ();

    IVector3i set(IVector3i vec);

    IVector3i set(int x, int y, int z);

    IVector3i setX(int x);

    IVector3i setY(int y);

    IVector3i setZ(int z);


    IVector3i clone();

    boolean equals(Object obj);

    String toString();
}
