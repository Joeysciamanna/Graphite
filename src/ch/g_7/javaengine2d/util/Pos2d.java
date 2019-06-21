package ch.g_7.javaengine2d.util;

public class Pos2d {

	private float x,y;
	
	public Pos2d() {}
	
	public Pos2d(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Pos2d ? ((Pos2d)obj).x == x && ((Pos2d)obj).y == y : false;
	}
	
	@Override
	public String toString() {
		return "Pos2d[" + x + ", " + y + "]";
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
}
