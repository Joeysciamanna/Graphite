package ch.g_7.graphite.util;

import org.joml.Vector4f;

public class Color{

	public final static Color TRANSPARENT = new Color(0,0,0,0);
	public final static Color WHITE = new Color(255,255,255);
	public final static Color BLACK = new Color(0,0,0);
	
	public final static Color RED     = new Color(255,0,0);
	public final static Color ORANGE = new Color(255,255,0);
	public final static Color GREEN   = new Color(0,255,0);
	public final static Color YELLOW  = new Color(0,255,255);
	public final static Color BLUE = new Color(0,0,255);
	public final static Color PURPLE = new Color(255,0,255);

	

	int r,g,b,a;
	
	public Color(int r, int g, int b, int a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public Color(int r, int g, int b) {
		this(r,g,b,255);
	}

	
	public Vector4f toVector() {
		return new Vector4f(r / 255f, g / 255f, b / 255f, a / 255f);
	}
	
	@Override
	public String toString() {
		return "Color[" + r +" "+ g +" "+ b +" "+ a +"]";
	}
	
	public void darker(int amount) {
		this.r -= amount;
		this.g -= amount;
		this.b -= amount;
	}
	
	public void lighter(int amount) {
		this.r += amount;
		this.g += amount;
		this.b += amount;
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
	
	public void setR(int r) {
		this.r = r;
	}
	
	public void setG(int g) {
		this.g = g;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	public void setA(int a) {
		this.a = a;
	}


	
	public static Color fromString(String value) {
		switch (value) {
		case "TRANSPARENT":
			return Color.TRANSPARENT;
		case "WHITE":
			return Color.WHITE;
		case "BLACK":
			return Color.BLACK;
		case "RED":
			return Color.RED;
		case "ORANGE":
			return Color.ORANGE;
		case "GREEN":
			return Color.GREEN;
		case "YELLOW":
			return Color.YELLOW;
		case "BLUE":
			return Color.BLUE;
		case "PURPLE":
			return Color.PURPLE;
		default:
			throw new IllegalArgumentException("Unexpected value: " + value);
		}
	}
}
