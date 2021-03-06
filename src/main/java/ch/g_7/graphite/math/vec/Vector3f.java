package ch.g_7.graphite.math.vec;

import java.util.Objects;

public class Vector3f implements IVector3f {

	public float x, y, z;


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
	public Vector3f cross(IROVector3f vec) {
		cross(vec.getX(), vec.getY(), vec.getZ(), this);
		return this;
	}
	
	@Override
	public Vector3f cross(float x, float y, float z) {
		cross(x, y, z, this);
		return this;
	}
	
	@Override
	public IVector3f cross(IROVector3f vec, IVector3f des) {
		return cross(vec.getX(), vec.getY(), vec.getZ(), des);
	}
	
	@Override
	public IVector3f cross(float x, float y, float z, IVector3f des) {
		float newX = this.y*z - this.z*y;
		float newY = this.z*x - this.x*z;
		float newZ = this.x*y - this.y*x;
		set(newX, newY, newZ);
		return des;
	}
	
	
	@Override
	public Vector3f normalize() {
		normalize(1, this);
		return this;
	}
	
	@Override
	public Vector3f normalize(float len) {
		normalize(len, this);
		return this;
	}
	
	@Override
	public IVector3f normalize(IVector3f des) {
		return normalize(1, des);
	}
	
	@Override
	public IVector3f normalize(float len, IVector3f des) {
		float f = (float) (1.0 / Math.sqrt(x * x + y * y + z * z)) * len;
		des.setX(x * f);
		des.setY(y * f);
		des.setZ(z * f);
		return des;
	}
	
	@Override
	public Vector3f rotateX(float angle) {
		rotateX(angle, this);
		return this;
	}
	
	@Override
	public IVector3f rotateX(float angle, IVector3f des) {
		float cs = (float) Math.cos(angle);
		float sn = (float) Math.sin(angle);
		float newY = y * cs - z * sn;
		float newZ = y * sn + z * cs;
		set(x, newY, newZ);
		return des;
	}
	
	@Override
	public Vector3f rotateY(float angle) {
		rotateY(angle, this);
		return this;
	}
	
	@Override
	public IVector3f rotateY(float angle, IVector3f des) {
		float cs = (float) Math.cos(angle);
		float sn = (float) Math.sin(angle);
		float newX =  x * cs + z * sn;
		float newZ = -x * sn + z * cs;
		set(newX, y, newZ);
		return des;
	}
	
	@Override
	public Vector3f rotateZ(float angle) {
		rotateZ(angle, this);
		return this;
	}
	
	@Override
	public IVector3f rotateZ(float angle, IVector3f des) {
		float cs = (float) Math.cos(angle);
		float sn = (float) Math.sin(angle);
		float newX = x * cs - y * sn;
		float newY = x * sn + y * cs;
		set(newX, newY, z);
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
		return (float) Math.sqrt(distanceSq(x, y, z));
	}
	
	@Override
	public float distanceSq(IROVector3f vec) {
		return distanceSq(vec.getX(), vec.getY(), vec.getZ());
	}
	
	@Override
	public float distanceSq(float x, float y, float z) {
		return (x-this.x)*(x-this.x) +  (y-this.y)*(y-this.y) + (z-this.z)*(z-this.z);
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
	public float lenght() {
		return (float) Math.sqrt(lenghtSq());
	}
	
	@Override
	public float lenghtSq() {
		return x*x + y*y + z*z;
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

	@Override
	public String toString() {
		return "Vec3f["+x+", "+y+", "+z+" ]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vector3f vec = (Vector3f) o;
		return vec.x == x &&
				vec.y == y &&
				vec.z == z;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}
}
