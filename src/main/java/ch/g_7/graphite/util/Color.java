package ch.g_7.graphite.util;

import org.joml.Vector4f;

public class Color{

	public final static Color TRANSPARENT = new Color(0,0,0,0);
	public final static Color WHITE = new Color(255,255,255);
	public final static Color BLACK = new Color(0,0,0);
	
	public final static Color RED     = new Color(255,0,0);
	public final static Color YELLOW  = new Color(255,255,0);
	public final static Color GREEN   = new Color(0,255,0);
	public final static Color CYAN = new Color(0,255,255);
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
	
	public Color darker(int amount) {
		return new Color(r - amount, g - amount, b - amount);
	}
	
	public Color lighter(int amount) {
		return new Color(r + amount, g + amount, b + amount);
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
		case "CYAN":
			return Color.CYAN;
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
