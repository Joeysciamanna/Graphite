package ch.g_7.graphite.base.ui;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public class ScrennDimension {
	
	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;
	
	private float percentageOfFather;
	private float percentageOfWindow;
	private int pixel;
	
	private float value;
	
	
	public ScrennDimension(int value) {
		this.value = value;
	}
	
	public ScrennDimension() {}
	
	
	public ScrennDimension recalculate(Vector2ic screenSize, Vector2fc fatherSize, byte axis) {
		if(axis == X_AXIS) {
			recalculate(screenSize.x(), fatherSize == null ? 2 : fatherSize.x());
		}else {
			recalculate(screenSize.y(), fatherSize == null ? 2 : fatherSize.y());
		}
		return this;
	}
	
	
	public ScrennDimension recalculate(int screenSize, float fatherSize) {
		value = 0;
		value += (float) pixel * 2 / screenSize;
		value += percentageOfFather / 50 * 2 / fatherSize;
		value += percentageOfWindow * 2 / 100;
		return this;
	}
	
	public ScrennDimension reset() {
		percentageOfWindow = 0;
		percentageOfFather = 0;
		pixel = 0;
		value = 0;
		return this;
	}
	
	public ScrennDimension setPercentageOfFather(float percentageOfFather) {
		this.percentageOfFather = percentageOfFather;
		return this;
	}
	
	public ScrennDimension setPercentageOfWindow(float percentageOfWindow) {
		this.percentageOfWindow = percentageOfWindow;
		return this;
	}
	
	public ScrennDimension setPixel(int pixel) {
		this.pixel = pixel;
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