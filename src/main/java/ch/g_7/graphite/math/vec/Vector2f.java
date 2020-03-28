package ch.g_7.graphite.math.vec;

import java.util.Objects;

public class Vector2f implements IVector2f {

	public float x, y;
	
	
	public Vector2f() {}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	
	@Override
	public Vector2f add(float i) {
		add(i, i, this);
		return this;
	}
	
	@Override
	public Vector2f add(IROVector2f vec) {
		add(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2f add(float x, float y) {
		add(x, y, this);
		return this;
	}

	@Override
	public IVector2f add(float i, IVector2f des) {
		return add(i, i, des);
	}
	
	@Override
	public IVector2f add(IROVector2f vec, IVector2f des) {
		return add(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2f add(float x, float y, IVector2f des) {
		des.setX(this.x + x);
		des.setY(this.y + y);
		return des;
	}

	
	@Override
	public Vector2f sub(float i) {
		sub(i, i, this);
		return this;
	}
	
	@Override
	public Vector2f sub(IROVector2f vec) {
		sub(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2f sub(float x, float y) {
		sub(x, y, this);
		return this;
	}
	
	@Override
	public IVector2f sub(float i, IVector2f des) {
		return sub(i, i, des);
	}

	@Override
	public IVector2f sub(IROVector2f vec, IVector2f des) {
		return sub(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2f sub(float x, float y, IVector2f des) {
		des.setX(this.x - x);
		des.setY(this.y - y);
		return des;
	}

	
	@Override
	public Vector2f mul(float i) {
		mul(i, i, this);
		return this;
	}
	
	@Override
	public Vector2f mul(IROVector2f vec) {
		mul(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2f mul(float x, float y) {
		mul(x, y, this);
		return this;
	}

	@Override
	public IVector2f mul(float i, IVector2f des) {
		return mul(i, i, des);
	}
	
	@Override
	public IVector2f mul(IROVector2f vec, IVector2f des) {
		return mul(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2f mul(float x, float y, IVector2f des) {
		des.setX(this.x * x);
		des.setY(this.y * y);
		return des;
	}
	

	@Override
	public Vector2f div(float i) {
		div(i, i, this);
		return this;
	}
	
	@Override
	public Vector2f div(IROVector2f vec) {
		div(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2f div(float x, float y) {
		div(x, y, this);
		return this;
	}

	@Override
	public IVector2f div(float i, IVector2f des) {
		return div(i, i, des);
	}
	
	@Override
	public IVector2f div(IROVector2f vec, IVector2f des) {
		return div(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2f div(float x, float y, IVector2f des) {
		des.setX(this.x / x);
		des.setY(this.y / y);
		return des;
	}

	
	@Override
	public Vector2f max(float i) {
		max(i, i, this);
		return this;
	}
	
	@Override
	public Vector2f max(IROVector2f vec) {
		max(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2f max(float x, float y) {
		max(x, y, this);
		return this;
	}

	@Override
	public IVector2f max(float i, IVector2f des) {
		return max(i, i, des);
	}
	
	@Override
	public IVector2f max(IROVector2f vec, IVector2f des) {
		return max(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2f max(float x, float y, IVector2f des) {
		des.setX(x > this.x ? x : this.x);
		des.setY(y > this.y ? y : this.y);
		return des;
	}


	@Override
	public Vector2f min(float i) {
		min(i, i, this);
		return this;
	}
	
	@Override
	public Vector2f min(IROVector2f vec) {
		min(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2f min(float x, float y) {
		min(x, y, this);
		return this;
	}

	@Override
	public IVector2f min(float i, IVector2f des) {
		return min(i, i, des);
	}
	
	@Override
	public IVector2f min(IROVector2f vec, IVector2f des) {
		return min(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2f min(float x, float y, IVector2f des) {
		des.setX(x < this.x ? x : this.x);
		des.setY(y < this.y ? y : this.y);
		return des;
	}

	@Override
	public Vector2f normalize() {
		normalize(1, this);
		return this;
	}
	
	@Override
	public Vector2f normalize(float len) {
		normalize(len, this);
		return this;
	}
	
	@Override
	public IVector2f normalize(IVector2f des) {
		return normalize(1, des);
	}
	
	@Override
	public IVector2f normalize(float len, IVector2f des) {
		float f = (float) (1.0 / Math.sqrt(x * x + y * y)) * len;
		des.setX(x * f);
		des.setY(y * f);
		return des;
	}
	
	
	@Override
	public Vector2f rotate(IROVector2f vec, float angle) {
		rotate(vec.getX(), vec.getY(), angle, this);
		return this;
	}
	
	@Override
	public Vector2f rotate(float x, float y, float angle) {
		rotate(x, y, angle, this);
		return this;
	}
	
	@Override
	public IVector2f rotate(IROVector2f vec, float angle, IVector2f des) {
		return rotate(vec.getX(), vec.getY(), angle, des);
	}
	
	@Override
	public IVector2f rotate(float x, float y, float angle, IVector2f des) {
		float cs = (float) Math.cos(angle);
		float sn = (float) Math.sin(angle);
		
		float newX = des.getX() - x;
		float newY = des.getY() - y;
		des.setX(newX * cs - newY * sn);
		des.setY(newX * sn + newY * cs);
		des.add(x, y);
		return des;
	}
	
	@Override
	public Vector2f rotate(float angle) {
		rotate(angle, this);
		return this;
	}
	
	@Override
	public IVector2f rotate(float angle, IVector2f des) {
		float cs = (float) Math.cos(angle);
		float sn = (float) Math.sin(angle);
		
		des.setX(x * cs - y * sn);
		des.setY(x * sn + y * cs);
		return des;
	}
	
	
	@Override
	public float dot(IROVector2f vec) {
		return dot(vec.getX(), vec.getY());
	}

	@Override
	public float dot(float x, float y) {
		return this.x * x + this.y + y;
	}

	@Override
	public float angle(IROVector2f vec) {
		return angle(vec.getX(), vec.getY());
	}

	@Override
	public float angle(float x, float y) {
		return (float) Math.atan2(y - this.y, x - this.x);
	}
	

	@Override
	public float distance(IROVector2f vec) {
		return distance(vec.getX(), vec.getY());
	}

	@Override
	public float distance(float x, float y) {
		return (float) Math.sqrt(distanceSq(x, y));
	}
	
	@Override
	public float distanceSq(IROVector2f vec) {
		return distanceSq(vec.getX(), vec.getY());
	}
	
	@Override
	public float distanceSq(float x, float y) {
		return (x - this.x) * (x - this.x) + (y - this.y) * (y - this.y);
	}

	@Override
	public float distanceX(float x) {
		return this.x - x;
	}

	@Override
	public float distanceY(float y) {
		return this.y - y;
	}

	
	@Override
	public float lenght() {
		return (float) Math.sqrt(lenghtSq());
	}
	
	@Override
	public float lenghtSq() {
		return x*x + y*y;
	}
	
	
	@Override
	public Vector3f transform3f(float z) {
		return new Vector3f(x, y, z);
	}

	@Override
	public Vector3i transform3i(int z) {
		return new Vector3i((int) x, (int) y, z);
	}

	@Override
	public Vector2i transform2i() {
		return new Vector2i((int) x, (int) y);
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
	public Vector2f set(IROVector2f vec) {
		return set(vec.getX(), vec.getY());
	}

	@Override
	public Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	@Override
	public Vector2f setX(float x) {
		this.x = x;
		return this;
	}

	@Override
	public Vector2f setY(float y) {
		this.y = y;
		return this;
	}

	
	@Override
	public Vector2f clone() {
		return new Vector2f(x, y);
	}
	
	@Override
	public String toString() {
		return "Vec2f["+x+", "+y+"]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vector2f vec = (Vector2f) o;
		return x == vec.x &&
				y == vec.y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}


}
