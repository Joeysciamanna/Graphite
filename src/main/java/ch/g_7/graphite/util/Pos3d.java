package ch.g_7.graphite.util;

public class Pos3d {
	
	private double x,y,z;
	
	public Pos3d() {}
	
	public Pos3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Pos3d ? ((Pos3d)obj).x == x && ((Pos3d)obj).y == y &&  ((Pos3d)obj).z == z : false;
	}
	
	@Override
	public String toString() {
		return "Pos3d[" + x + ", " + y + ", " + z + "]";
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
	
	public double getZ() {
		return z;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
}
