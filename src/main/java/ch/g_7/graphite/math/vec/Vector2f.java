package ch.g_7.graphite.math.vec;


public class Vector2f implements IVector2f {

	protected float x, y;
	
	
	public Vector2f() {}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public Vector2f add(IVector2f vec) {
		return add(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2f add(float x, float y) {
		return add(x, y, this);
	}

	@Override
	public Vector2f add(IVector2f vec, Vector2f des) {
		return add(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2f add(float x, float y, Vector2f des) {
		des.x = this.x + x;
		des.y = this.y + y;
		return this;
	}

	
	@Override
	public Vector2f sub(IVector2f vec) {
		return sub(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2f sub(float x, float y) {
		return sub(x, y, this);
	}

	@Override
	public Vector2f sub(IVector2f vec, Vector2f des) {
		return sub(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2f sub(float x, float y, Vector2f des) {
		des.x = this.x - x;
		des.y = this.y - y;
		return this;
	}

	
	@Override
	public Vector2f mul(IVector2f vec) {
		return mul(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2f mul(float x, float y) {
		return mul(x, y, this);
	}

	@Override
	public Vector2f mul(IVector2f vec, Vector2f des) {
		return mul(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2f mul(float x, float y, Vector2f des) {
		des.x = this.x * x;
		des.y = this.y * y;
		return this;
	}
	

	@Override
	public Vector2f div(IVector2f vec) {
		return div(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2f div(float x, float y) {
		return div(x, y, this);
	}

	@Override
	public Vector2f div(IVector2f vec, Vector2f des) {
		return div(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2f div(float x, float y, Vector2f des) {
		des.x = this.x / x;
		des.y = this.y / y;
		return this;
	}

	@Override
	public Vector2f max(IVector2f vec) {
		return max(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2f max(float x, float y) {
		return max(x, y, this);
	}

	@Override
	public Vector2f max(IVector2f vec, Vector2f des) {
		return max(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2f max(float x, float y, Vector2f des) {
		des.x = x > this.x ? x : this.x;
		des.y = y > this.y ? y : this.y;
		return this;
	}


	@Override
	public Vector2f min(IVector2f vec) {
		return min(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2f min(float x, float y) {
		return min(x, y, this);
	}

	@Override
	public Vector2f min(IVector2f vec, Vector2f des) {
		return min(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2f min(float x, float y, Vector2f des) {
		des.x = x < this.x ? x : this.x;
		des.y = y < this.y ? y : this.y;
		return this;
	}

	
	@Override
	public float dot(IVector2f vec) {
		return dot(vec.getX(), vec.getY());
	}

	@Override
	public float dot(float x, float y) {
		return this.x * x + this.y + y;
	}

	@Override
	public float angle(IVector2f vec) {
		return angle(vec.getX(), vec.getY());
	}

	@Override
	public float angle(float x, float y) {
		return (float) Math.atan2(y - this.y, x - this.x);
	}

	@Override
	public float distance(IVector2f vec) {
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
		return null;
	}

	@Override
	public Vector3i transform3i(int z) {
		// TODO Auto-generated method stub
		return null;
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
	public Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	@Override
	public Vector2f set(IVector2f vec) {
		return set(vec.getX(), vec.getY());
	}

	@Override
	public Vector2f clone() {
		return new Vector2f(x, y);
	}


}
