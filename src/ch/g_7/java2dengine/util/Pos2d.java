package ch.g_7.java2dengine.util;

public class Pos2d {

	private double x,y;
	
	public Pos2d() {}
	
	public Pos2d(double x, double y) {
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
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
}
