package ch.g_7.graphite.entity.ui.dimension;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public interface IScreenDimension {
	
	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;
	
	
	public IScreenDimension recalculate(Vector2ic screenSize, Vector2fc fatherSize, byte axis);
	
	public IScreenDimension recalculate(int screenSize, float fatherSize);
	
	public IScreenDimension reset();
	
	public IScreenDimension add(SimpleScreenDimension dimension);
	
	public IScreenDimension remove(SimpleScreenDimension dimension);
	
	public IScreenDimension addPF(float percentageOfFather);
	
	public IScreenDimension removePF(float percentageOfFather);
	
	public IScreenDimension addPW(float percentageOfWindow);
	
	public IScreenDimension removePW(float percentageOfWindow);
	
	public IScreenDimension addPixel(int pixel);
	
	public IScreenDimension removePixel(int pixel);
	
	/**
	 * from 0 to 2
	 * @return
	 */
	public float getValue();
}
