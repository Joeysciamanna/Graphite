package ch.g_7.graphite.math.vec;


public class Vector2i implements IVector2i {

	protected int x, y;
	
	
	public Vector2i() {}
	
	public Vector2i(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public Vector2i add(IVector2i vec) {
		return add(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2i add(int x, int y) {
		return add(x, y, this);
	}

	@Override
	public Vector2i add(IVector2i vec, Vector2i des) {
		return add(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2i add(int x, int y, Vector2i des) {
		des.x = this.x + x;
		des.y = this.y + y;
		return this;
	}

	
	@Override
	public Vector2i sub(IVector2i vec) {
		return sub(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2i sub(int x, int y) {
		return sub(x, y, this);
	}

	@Override
	public Vector2i sub(IVector2i vec, Vector2i des) {
		return sub(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2i sub(int x, int y, Vector2i des) {
		des.x = this.x - x;
		des.y = this.y - y;
		return this;
	}

	
	@Override
	public Vector2i mul(IVector2i vec) {
		return mul(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2i mul(int x, int y) {
		return mul(x, y, this);
	}

	@Override
	public Vector2i mul(IVector2i vec, Vector2i des) {
		return mul(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2i mul(int x, int y, Vector2i des) {
		des.x = this.x * x;
		des.y = this.y * y;
		return this;
	}
	

	@Override
	public Vector2i div(IVector2i vec) {
		return div(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2i div(int x, int y) {
		return div(x, y, this);
	}

	@Override
	public Vector2i div(IVector2i vec, Vector2i des) {
		return div(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2i div(int x, int y, Vector2i des) {
		des.x = this.x / x;
		des.y = this.y / y;
		return this;
	}

	@Override
	public Vector2i max(IVector2i vec) {
		return max(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2i max(int x, int y) {
		return max(x, y, this);
	}

	@Override
	public Vector2i max(IVector2i vec, Vector2i des) {
		return max(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2i max(int x, int y, Vector2i des) {
		des.x = x > this.x ? x : this.x;
		des.y = y > this.y ? y : this.y;
		return this;
	}


	@Override
	public Vector2i min(IVector2i vec) {
		return min(vec.getX(), vec.getY(), this);
	}

	@Override
	public Vector2i min(int x, int y) {
		return min(x, y, this);
	}

	@Override
	public Vector2i min(IVector2i vec, Vector2i des) {
		return min(vec.getX(), vec.getY(), des);
	}

	@Override
	public Vector2i min(int x, int y, Vector2i des) {
		des.x = x < this.x ? x : this.x;
		des.y = y < this.y ? y : this.y;
		return this;
	}

	
	@Override
	public float dot(IVector2i vec) {
		return dot(vec.getX(), vec.getY());
	}

	@Override
	public float dot(int x, int y) {
		return this.x * x + this.y + y;
	}

	@Override
	public float angle(IVector2i vec) {
		return angle(vec.getX(), vec.getY());
	}

	@Override
	public float angle(int x, int y) {
		return (int) Math.atan2(y - this.y, x - this.x);
	}

	@Override
	public float distance(IVector2i vec) {
		return distance(vec.getX(), vec.getY());
	}

	@Override
	public float distance(int x, int y) {
		return (int) Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
	}

	@Override
	public int distanceX(int x) {
		return this.x - x;
	}

	@Override
	public int distanceY(int y) {
		return this.y - y;
	}

	@Override
	public Vector3i transform3i(int z) {
		return null;
	}

	@Override
	public Vector2f transform2f() {
		return new Vector2f(x, y);
	}

	@Override
	public Vector3f transform3f(float z) {
		return null;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public Vector2i setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public Vector2i setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public Vector2i set(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}

	@Override
	public Vector2i set(IVector2i vec) {
		return set(vec.getX(), vec.getY());
	}

	@Override
	public Vector2i clone() {
		return new Vector2i(x, y);
	}

	
}
