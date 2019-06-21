package ch.g_7.javaengine2d.util;

public class Pos3d {
	
	private float x,y,z;
	
	public Pos3d() {}
	
	public Pos3d(float x, float y, float z) {
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
	
	public float getZ() {
		return z;
	}
	
	public void setZ(float z) {
		this.z = z;
	}
}
