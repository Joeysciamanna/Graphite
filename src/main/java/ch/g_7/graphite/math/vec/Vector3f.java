package ch.g_7.graphite.math.vec;

public class Vector3f implements IVector3f {

	@Override
	public Vector3f add(IVector3f vec) {
		return add(vec.getX(), vec.getY(), vec.getZ(), this);
	}

	@Override
	public Vector3f add(float x, float y, float z) {
		return add(x, y, z, this);
	}

	@Override
	public Vector3f add(IVector3f vec, Vector3f des) {
		return add(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public Vector3f add(float x, float y, float z, Vector3f des) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3f sub(IVector3f vec) {
		return sub(vec.getX(), vec.getY(), vec.getZ(), this);
	}

	@Override
	public Vector3f sub(float x, float y, float z) {
		return sub(x, y, z, this);
	}

	@Override
	public Vector3f sub(IVector3f vec, Vector3f des) {
		return sub(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public Vector3f sub(float x, float y, float z, Vector3f des) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3f mul(IVector3f vec) {
		return mul(vec.getX(), vec.getY(), vec.getZ(), this);
	}

	@Override
	public Vector3f mul(float x, float y, float z) {
		return mul(x, y, z, this);
	}

	@Override
	public Vector3f mul(IVector3f vec, Vector3f des) {
		return mul(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public Vector3f mul(float x, float y, float z, Vector3f des) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3f div(IVector3f vec) {
		return div(vec.getX(), vec.getY(), vec.getZ(), this);
	}

	@Override
	public Vector3f div(float x, float y, float z) {
		return div(x, y, z, this);
	}

	@Override
	public Vector3f div(IVector3f vec, Vector3f des) {
		return div(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public Vector3f div(float x, float y, float z, Vector3f des) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3f max(IVector3f vec) {
		return max(vec.getX(), vec.getY(), vec.getZ(), this);
	}

	@Override
	public Vector3f max(float x, float y, float z) {
		return max(x, y, z, this);
	}

	@Override
	public Vector3f max(IVector3f vec, Vector3f des) {
		return max(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public Vector3f max(float x, float y, float z, Vector3f des) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3f min(IVector3f vec) {
		return min(vec.getX(), vec.getY(), vec.getZ(), this);
	}

	@Override
	public Vector3f min(float x, float y, float z) {
		return min(x, y, z, this);
	}

	@Override
	public Vector3f min(IVector3f vec, Vector3f des) {
		return min(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public Vector3f min(float x, float y, float z, Vector3f des) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float dot(IVector3f vec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float dot(float x, float y, float z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float angle(IVector3f vec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float angle(float x, float y, float z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float distance(IVector3f vec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float distance(float x, float y, float z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float distanceX(float x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float distanceY(float y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float distanceZ(float z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector3i transform3i() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector2f transform2f() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector2i transform2i() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector3f setX(float x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3f setY(float y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3f setZ(float z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3f set(float x, float y, float z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3f set(IVector3f vec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3f clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
