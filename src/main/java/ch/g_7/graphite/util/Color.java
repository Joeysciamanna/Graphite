package ch.g_7.graphite.util;

import org.joml.Vector4f;
import org.joml.Vector4fc;

public class Color {

	int r,g,b,a;
	
	private Color(int r, int g, int b, int a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public static Color getColor(int r, int g, int b, int a) {
		return new Color(r, g, b, a);
	}
	
	public static Color getColor(int r, int g, int b) {
		return new Color(r, g, b, 255);
	}
	
	public static Color getColor(Vector4fc vector) {
		return new Color((int) (vector.x() * 255f),(int) (vector.y()  * 255f),(int) (vector.z() * 255f),(int) (vector.w() * 255f));
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


}
