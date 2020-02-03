package ch.g_7.graphite.math.vec;

import org.joml.Vector3i;

public class Vector3f implements IVector3f {

	protected float x, y, z;

	public Vector3f() {}

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

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
		des.x = this.x + x;
		des.y = this.y + y;
		des.z = this.z + z;
		return des;
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
		des.x = this.x - x;
		des.y = this.y - y;
		des.z = this.z - z;
		return des;
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
		des.x = this.x * x;
		des.y = this.y * y;
		des.z = this.z * z;
		return des;
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
		des.x = this.x / x;
		des.y = this.y / y;
		des.z = this.z / z;
		return des;
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
		des.x = x > this.x ? x : this.x;
		des.y = y > this.y ? y : this.y;
		des.z = z > this.z ? z : this.z;
		return des;
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
		des.x = x < this.x ? x : this.x;
		des.y = y < this.y ? y : this.y;
		des.z = z < this.z ? z : this.z;
		return des;
	}

	@Override
	public float dot(IVector3f vec) {
		return dot(vec.getX(), vec.getY(), vec.getZ());
	}

	@Override
	public float dot(float x, float y, float z) {
		return this.x * x + this.y + y + this.z * z;
	}

	@Override
	public float angle(IVector3f vec) {
		return angle(vec.getX(), vec.getY(), vec.getZ());
	}

	@Override
	public float angle(float x, float y, float z) {
		float ab = this.x * x + this.y * y + this.z * z;
		float a = (float) Math.sqrt(this.x * this.x + (this.y * this.y) + (this.z * this.z));
		float b = (float) Math.sqrt(x * x + y * y + z * z);
		return (float) Math.acos(ab / a * b);
	}

	@Override
	public float distance(IVector3f vec) {
		return distance(vec.getX(), vec.getY(), vec.getZ());
	}

	@Override
	public float distance(float x, float y, float z) {
		return (float) Math.sqrt((x-this.x)*(x-this.x) +  (y-this.y)*(y-this.y) + (z-this.z)*(z-this.z));
	}

	@Override
	public float distanceX(float x) {
		return x - this.x;
	}

	@Override
	public float distanceY(float y) {
		return y - this.y;
	}

	@Override
	public float distanceZ(float z) {
		return z - this.z;
	}

	@Override
	public Vector3i transform3i() {
		return null;
	}

	@Override
	public Vector2f transform2f() {
		return new Vector2f(x, y);
	}

	@Override
	public Vector2i transform2i() {
		return new Vector2i((int)x, (int)y);
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getZ() {
		return z;
	}

	@Override
	public Vector3f set(IVector3f vec) {
		return set(vec.getX(), vec.getY(), vec.getZ());
	}

	@Override
	public Vector3f set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	@Override
	public Vector3f setX(float x) {
		this.x = x;
		return this;
	}

	@Override
	public Vector3f setY(float y) {
		this.y = y;
		return this;
	}

	@Override
	public Vector3f setZ(float z) {
		this.z = z;
		return this;
	}

	@Override
	public Vector3f clone() {
		return new Vector3f(x, y, z);
	}

}
