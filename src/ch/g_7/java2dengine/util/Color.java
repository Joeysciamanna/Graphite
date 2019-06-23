package ch.g_7.java2dengine.util;

public class Color {

	short r,g,b,a;
	
	public Color(short r, short g, short b, short a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public Color(java.awt.Color color) {
		this((short)color.getRed(),(short)color.getGreen(),(short)color.getBlue(),(short)color.getAlpha());
	}
	
	public Color(int r, int g, int b, int a) {
		this((short)r,(short)g,(short)b,(short)a);
	}

	public short getR() {
		return r;
	}
	
	public short getG() {
		return g;
	}
	
	public short getB() {
		return b;
	}

	public short getA() {
		return a;
	}
	
	public void setR(short r) {
		this.r = r;
	}
	
	public void setG(short g) {
		this.g = g;
	}
	
	public void setB(short b) {
		this.b = b;
	}
	
	public void setA(short a) {
		this.a = a;
	}

}
