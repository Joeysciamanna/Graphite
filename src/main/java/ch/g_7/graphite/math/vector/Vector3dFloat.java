package ch.g_7.graphite.math.vector;

public class Vector3dFloat implements IVector3dFloat{

protected float x,y,z;
	
	public Vector3dFloat(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3dFloat() {}


	public Vector3dFloat add(IVector3dFloat vector) {
		this.x += vector.getX();
		this.y += vector.getY();
		this.z += vector.getZ();
		return this;
	}

	public Vector3dFloat remove(IVector3dFloat vector) {
		this.x -= vector.getX();
		this.y -= vector.getY();
		this.z -= vector.getZ();
		return this;
	}

	public Vector3dFloat add(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector3dFloat remove(float x, float y, float z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector3dFloat addX(float x) {
		this.x += x;
		return this;
	}

	public Vector3dFloat addY(float y) {
		this.y += y;
		return this;
	}
	
	public Vector3dFloat addZ(float z) {
		this.z += z;
		return this;
	}

	public Vector3dFloat removeX(float x) {
		this.x -= x;
		return this;
	}

	public Vector3dFloat removeY(float y) {
		this.y -= y;
		return this;
	}
	
	public Vector3dFloat removeZ(float z) {
		this.z -= z;
		return this;
	}

	public Vector3dFloat abs() {
		this.x = Math.abs(x);
		this.y = Math.abs(y);
		this.z = Math.abs(z);
		return this;
	}

	public Vector3dFloat set(IVector3dFloat vector) {
		this.x = vector.getX();
		this.y = vector.getY();
		this.z = vector.getZ();
		return this;
	}

	public Vector3dFloat set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	public Vector3dFloat setX(float x) {
		this.x = x;
		return this;
	}

	public Vector3dFloat setY(float y) {
		this.y = y;
		return this;
	}
	
	public Vector3dFloat setZ(float z) {
		this.z = z;
		return this;
	}
	
	@Override
	public float getX() {
		return y;
	}
	
	@Override
	public float getY() {
		return x;
	}
	
	@Override
	public float getZ() {
		return z;
	}

}
