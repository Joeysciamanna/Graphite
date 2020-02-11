package ch.g_7.graphite.math.vec3;

import ch.g_7.graphite.math.vec2.Vector2f;
import ch.g_7.graphite.math.vec2.Vector2i;

public class Vector3f implements IVector3f {

	protected float x, y, z;

	public Vector3f() {}

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public Vector3f add(float i) {
		add(i, i, i, this);
		return this;
	}
	
	@Override
	public Vector3f add(IROVector3f vec) {
		add(vec.getX(), vec.getY(), vec.getZ(), this);
		return this;
	}

	@Override
	public Vector3f add(float x, float y, float z) {
		add(x, y, z, this);
		return this;
	}

	@Override
	public IVector3f add(float i, IVector3f des) {
		return add(i,i,i,des);
	}
	
	@Override
	public IVector3f add(IROVector3f vec, IVector3f des) {
		return add(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public IVector3f add(float x, float y, float z, IVector3f des) {
		des.setX(this.x + x);
		des.setY(this.y + y);
		des.setZ(this.z + z);
		return des;
	}

	
	@Override
	public Vector3f sub(float i) {
		sub(i, i, i, this);
		return this;
	}
	
	@Override
	public Vector3f sub(IROVector3f vec) {
		sub(vec.getX(), vec.getY(), vec.getZ(), this);
		return this;
	}

	@Override
	public Vector3f sub(float x, float y, float z) {
		sub(x, y, z, this);
		return this;
	}

	@Override
	public IVector3f sub(float i, IVector3f des) {
		return sub(i,i,i,des);
	}
	
	@Override
	public IVector3f sub(IROVector3f vec, IVector3f des) {
		return sub(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public IVector3f sub(float x, float y, float z, IVector3f des) {
		des.setX(this.x - x);
		des.setY(this.y - y);
		des.setZ(this.z - z);
		return des;
	}

	
	@Override
	public Vector3f mul(float i) {
		mul(i, i, i, this);
		return this;
	}
	
	@Override
	public Vector3f mul(IROVector3f vec) {
		mul(vec.getX(), vec.getY(), vec.getZ(), this);
		return this;
	}

	@Override
	public Vector3f mul(float x, float y, float z) {
		mul(x, y, z, this);
		return this;
	}

	@Override
	public IVector3f mul(float i, IVector3f des) {
		return mul(i,i,i,des);
	}
	
	@Override
	public IVector3f mul(IROVector3f vec, IVector3f des) {
		return mul(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public IVector3f mul(float x, float y, float z, IVector3f des) {
		des.setX(this.x * x);
		des.setY(this.y * y);
		des.setZ(this.z * z);
		return des;
	}
	
	
	@Override
	public Vector3f div(float i) {
		div(i, i, i, this);
		return this;
	}

	@Override
	public Vector3f div(IROVector3f vec) {
		div(vec.getX(), vec.getY(), vec.getZ(), this);
		return this;
	}

	@Override
	public Vector3f div(float x, float y, float z) {
		div(x, y, z, this);
		return this;
	}

	@Override
	public IVector3f div(float i, IVector3f des) {
		return div(i,i,i,des);
	}
	
	@Override
	public IVector3f div(IROVector3f vec, IVector3f des) {
		return div(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public IVector3f div(float x, float y, float z, IVector3f des) {
		des.setX(this.x / x);
		des.setY(this.y / y);
		des.setZ(this.z / z);
		return des;
	}
	
	
	@Override
	public Vector3f max(float i) {
		max(i, i, i, this);
		return this;
	}

	@Override
	public Vector3f max(IROVector3f vec) {
		max(vec.getX(), vec.getY(), vec.getZ(), this);
		return this;
	}

	@Override
	public Vector3f max(float x, float y, float z) {
		max(x, y, z, this);
		return this;
	}

	@Override
	public IVector3f max(float i, IVector3f des) {
		return max(i,i,i,des);
	}
	
	@Override
	public IVector3f max(IROVector3f vec, IVector3f des) {
		return max(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public IVector3f max(float x, float y, float z, IVector3f des) {
		des.setX(x > this.x ? x : this.x);
		des.setY(y > this.y ? y : this.y);
		des.setZ(z > this.z ? z : this.z);
		return des;
	}
	
	
	@Override
	public Vector3f min(float i) {
		min(i, i, i, this);
		return this;
	}

	@Override
	public Vector3f min(IROVector3f vec) {
		min(vec.getX(), vec.getY(), vec.getZ(), this);
		return this;
	}

	@Override
	public Vector3f min(float x, float y, float z) {
		min(x, y, z, this);
		return this;
	}

	@Override
	public IVector3f min(float i, IVector3f des) {
		return min(i,i,i,des);
	}
	
	@Override
	public IVector3f min(IROVector3f vec, IVector3f des) {
		return min(vec.getX(), vec.getY(), vec.getZ(), des);
	}

	@Override
	public IVector3f min(float x, float y, float z, IVector3f des) {
		des.setX(x < this.x ? x : this.x);
		des.setY(y < this.y ? y : this.y);
		des.setZ(z < this.z ? z : this.z);
		return des;
	}

	@Override
	public float dot(IROVector3f vec) {
		return dot(vec.getX(), vec.getY(), vec.getZ());
	}

	@Override
	public float dot(float x, float y, float z) {
		return this.x * x + this.y + y + this.z * z;
	}

	@Override
	public float angle(IROVector3f vec) {
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
	public float distance(IROVector3f vec) {
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
	public Vector3f set(IROVector3f vec) {
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
