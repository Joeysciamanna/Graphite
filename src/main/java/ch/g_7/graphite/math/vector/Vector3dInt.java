package ch.g_7.graphite.math.vector;

public class Vector3dInt implements IVector3dInt{

	protected int x,y,z;
	
	public Vector3dInt(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3dInt() {}


	public Vector3dInt add(IVector3dInt vector) {
		this.x += vector.getX();
		this.y += vector.getY();
		this.z += vector.getZ();
		return this;
	}

	public Vector3dInt remove(IVector3dInt vector) {
		this.x -= vector.getX();
		this.y -= vector.getY();
		this.z -= vector.getZ();
		return this;
	}

	public Vector3dInt add(int x, int y, int z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector3dInt remove(int x, int y, int z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector3dInt addX(int x) {
		this.x += x;
		return this;
	}

	public Vector3dInt addY(int y) {
		this.y += y;
		return this;
	}
	
	public Vector3dInt addZ(int z) {
		this.z += z;
		return this;
	}

	public Vector3dInt removeX(int x) {
		this.x -= x;
		return this;
	}

	public Vector3dInt removeY(int y) {
		this.y -= y;
		return this;
	}
	
	public Vector3dInt removeZ(int z) {
		this.z -= z;
		return this;
	}

	public Vector3dInt abs() {
		this.x = Math.abs(x);
		this.y = Math.abs(y);
		this.z = Math.abs(z);
		return this;
	}

	public Vector3dInt set(IVector3dInt vector) {
		this.x = vector.getX();
		this.y = vector.getY();
		this.z = vector.getZ();
		return this;
	}

	public Vector3dInt set(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	public Vector3dInt setX(int x) {
		this.x = x;
		return this;
	}

	public Vector3dInt setY(int y) {
		this.y = y;
		return this;
	}
	
	public Vector3dInt setZ(int z) {
		this.z = z;
		return this;
	}
	
	@Override
	public int getX() {
		return y;
	}
	
	@Override
	public int getY() {
		return x;
	}
	
	@Override
	public int getZ() {
		return z;
	}

	
	
}
