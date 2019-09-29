package ch.g_7.graphite.util;

public class Dimension2d {

	private double width, height;
	
	public Dimension2d() {}

	public Dimension2d(double d, double e) {
		this.width = d;
		this.height = e;
	}
	
	@Override
	public String toString() {
		return "Dim2d[" + width + ", " + height + "]";
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
}
