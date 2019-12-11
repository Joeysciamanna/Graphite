package ch.g_7.graphite.math.vector;

public class Vector2dInt implements IVector2dInt {

	protected int x, y;

	public Vector2dInt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Vector2dInt() {
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	public Vector2dInt add(IVector2dInt vector) {
		this.x += vector.getX();
		this.y += vector.getY();
		return this;
	}

	public Vector2dInt remove(IVector2dInt vector) {
		this.x -= vector.getX();
		this.y -= vector.getY();
		return this;
	}

	public Vector2dInt add(int x, int y) {
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2dInt remove(int x, int y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2dInt addX(int x) {
		this.x += x;
		return this;
	}

	public Vector2dInt addY(int y) {
		this.y += y;
		return this;
	}

	public Vector2dInt removeX(int x) {
		this.x -= x;
		return this;
	}

	public Vector2dInt removeY(int y) {
		this.y -= y;
		return this;
	}

	public Vector2dInt abs() {
		this.x = Math.abs(x);
		this.y = Math.abs(y);
		return this;
	}

	public Vector2dInt set(IVector2dInt vector) {
		this.x = vector.getX();
		this.y = vector.getY();
		return this;
	}

	public Vector2dInt set(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public Vector2dInt setX(int x) {
		this.x = x;
		return this;
	}

	public Vector2dInt setY(int y) {
		this.y = y;
		return this;
	}
}
