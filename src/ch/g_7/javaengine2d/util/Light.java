package ch.g_7.javaengine2d.util;

import org.joml.Vector4f;

public class Light {

	private short r,g,b;
	
	
	public Light() {
		r = -256;
		g = -256;
		b = -256;
	}
	
	public Light(short r, short g, short b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Light(int r, int g, int b) {
		this((short)r,(short)g,(short)b);
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
	
	public void setR(short r) {
		this.r = r;
	}
	
	public void setG(short g) {
		this.g = g;
	}
	
	public void setB(short b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Light["+r+" "+g+" "+b+"]";
	}
	
	public Vector4f toVector() {
		return new Vector4f((float)r/256, (float)g/256, (float)b/256, 0);
	}

	public boolean isDark() {
		return r == -255 && g == -255 && b == -255;
	}
	
	public void increase(short value) {
		r = (short) (r + value);
		g = (short) (g + value);
		b = (short) (b + value);
	}
	
	public void decrese(short value) {
		r = (short) (r - value);
		g = (short) (g - value);
		b = (short) (b - value);
	}
	
}
