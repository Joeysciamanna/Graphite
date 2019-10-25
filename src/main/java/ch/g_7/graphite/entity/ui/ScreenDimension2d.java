package ch.g_7.graphite.entity.ui;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

public class ScreenDimension2d {

	private final ScreenDimension xAxis;
	private final ScreenDimension yAxis;
	
	
	public ScreenDimension2d(ScreenDimension xAxis, ScreenDimension yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
	
	public ScreenDimension2d() {
		this(new ScreenDimension(), new ScreenDimension());
	}
	
	public ScreenDimension2d recalculate(Vector2ic screenSize, Vector2fc fatherSize) {
		xAxis.recalculate(screenSize, fatherSize, ScreenDimension.X_AXIS);
		xAxis.recalculate(screenSize, fatherSize, ScreenDimension.Y_AXIS);
		return this;
	}
	
	
	public ScreenDimension2d reset() {
		xAxis.reset();
		yAxis.reset();
		return this;
	}
	
	public ScreenDimension getXAxis() {
		return xAxis;
	}
	
	public ScreenDimension getYAxis() {
		return yAxis;
	}
	
	public float getXValue() {
		return xAxis.getValue();
	}

	public float getYValue() {
		return yAxis.getValue();
	}
	
	public Vector2f toVector() {
		return new Vector2f(getXValue(), getYValue());
	}

}
