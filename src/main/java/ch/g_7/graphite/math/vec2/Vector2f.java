package ch.g_7.graphite.math.vec2;

import java.util.Objects;

import ch.g_7.graphite.math.vec3.Vector3f;
import ch.g_7.graphite.math.vec3.Vector3i;

public class Vector2f implements IVector2f {

	protected float x, y;
	
	
	public Vector2f() {}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
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
		return (float) Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
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
	public boolean equals(Object obj) {
		if(obj instanceof IROVector2f) {
			IROVector2f vec = (IROVector2f) obj;
			return vec.getX() == x && vec.getY() == y;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}


}
