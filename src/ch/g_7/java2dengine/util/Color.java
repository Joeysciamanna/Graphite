package ch.g_7.java2dengine.util;

public class Color {

	float r,g,b,a;
	
	
	
	public Color(java.awt.Color color) {
		this(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha());
	}
	
	public Color(int r, int g, int b, int a) {
		this.r = (float)(r+1)/256;
		this.g = (float)(g+1)/256;
		this.b = (float)(b+1)/256;
		this.a = (float)(a+1)/256;
	}
	
	public Color(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public float getR() {
		return r;
	}
	
	public float getG() {
		return g;
	}
	
	public float getB() {
		return b;
	}

	public float getA() {
		return a;
	}
	
	public void setR(float r) {
		this.r = r;
	}
	
	public void setG(float g) {
		this.g = g;
	}
	
	public void setB(float b) {
		this.b = b;
	}
	
	public void setA(float a) {
		this.a = a;
	}

}
