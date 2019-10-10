package ch.g_7.graphite.base.ui;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public class ScreenDimension {
	
	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;
	
	private float pF;
	private float pW;
	private int pixel;
	
	private float value;
	
	public ScreenDimension(float value) {
		this.value = value;
	}
	
	public ScreenDimension() {}
	
	
	public ScreenDimension recalculate(Vector2ic screenSize, Vector2fc fatherSize, byte axis) {
		if(axis == X_AXIS) {
			recalculate(screenSize.x(), fatherSize.x());
		}else {
			recalculate(screenSize.y(), fatherSize.y());
		}
		return this;
	}
	
	
	public ScreenDimension recalculate(int screenSize, float fatherSize) {
		value = 0;
		value += (float) pixel * 2 / screenSize;
		value += fatherSize * (pF == 0 ? 0 : (pF/100));
		value += pW * 2 / 100;
		return this;
	}
	

	
	public ScreenDimension reset() {
		pW = 0;
		pF = 0;
		pixel = 0;
		value = 0;
		return this;
	}
	
	
	public ScreenDimension add(ScreenDimension dimension) {
		addPF(dimension.pF);
		addPW(dimension.pW);
		addPixel(dimension.pixel);
		return this;
	}
	
//	public ScreenDimension setPercentageOfFather(float percentageOfFather) {
//		this.percentageOfFather = percentageOfFather;
//		return this;
//	}
	
	public ScreenDimension addPF(float percentageOfFather) {
		this.pF += percentageOfFather;
		return this;
	}
	
	public ScreenDimension removePF(float percentageOfFather) {
		this.pF -= percentageOfFather;
		return this;
	}
	
//	public ScreenDimension setPercentageOfWindow(float percentageOfWindow) {
//		this.percentageOfWindow = percentageOfWindow;
//		return this;
//	}
	
	public ScreenDimension addPW(float percentageOfWindow) {
		this.pW += percentageOfWindow;
		return this;
	}
	
	public ScreenDimension removePW(float percentageOfWindow) {
		this.pW -= percentageOfWindow;
		return this;
	}
	
//	public ScreenDimension setPixel(int pixel) {
//		this.pixel = pixel;
//		return this;
//	}
	
	public ScreenDimension addPixel(int pixel) {
		this.pixel += pixel;
		return this;
	}
	
	public ScreenDimension removePixel(int pixel) {
		this.pixel -= pixel;
		return this;
	}
	
	/**
	 * from 0 to 2
	 * @return
	 */
	public float getValue() {
		return value;
	}
	
}
