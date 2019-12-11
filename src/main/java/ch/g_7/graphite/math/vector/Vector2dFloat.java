package ch.g_7.graphite.math.vector;

public class Vector2dFloat implements IVector2dFloat{

	protected float x,y;
	
	public Vector2dFloat(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2dFloat() {}
	
	
	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}
	
	public Vector2dFloat add(IVector2dFloat vector) {
		this.x += vector.getX();
		this.y += vector.getY();
		return this;
	}
	
	public Vector2dFloat remove(IVector2dFloat vector) {
		this.x -= vector.getX();
		this.y -= vector.getY();
		return this;
	}
	
	public Vector2dFloat add(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Vector2dFloat remove(float x, float y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	
	public Vector2dFloat addX(float x) {
		this.x += x;
		return this;
	}

	public Vector2dFloat addY(float y) {
		this.y += y;
		return this;
	}

	public Vector2dFloat removeX(float x) {
		this.x -= x;
		return this;
	}

	public Vector2dFloat removeY(float y) {
		this.y -= y;
		return this;
	}

	public Vector2dFloat abs() {
		this.x = Math.abs(x);
		this.y = Math.abs(y);
		return this;
	}
	
	public Vector2dFloat set(IVector2dFloat vector) {
		this.x = vector.getX();
		this.y = vector.getY();
		return this;
	}
	
	public Vector2dFloat set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Vector2dFloat setX(float x) {
		this.x = x;
		return this;
	}
	
	public Vector2dFloat setY(float y) {
		this.y = y;
		return this;
	}
	
}
