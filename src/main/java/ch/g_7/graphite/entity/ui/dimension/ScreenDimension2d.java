package ch.g_7.graphite.entity.ui.dimension;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.util.task.Task.VoidTask;

public class ScreenDimension2d {

	private final SimpleScreenDimension xAxis;
	private final SimpleScreenDimension yAxis;
	
	
	public ScreenDimension2d(SimpleScreenDimension xAxis, SimpleScreenDimension yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
	
	public ScreenDimension2d(float xAxis, float yAxis) {
		this(new SimpleScreenDimension(xAxis), new SimpleScreenDimension(yAxis));
	}
	
	public ScreenDimension2d(Vector2ic vector) {
		this(new SimpleScreenDimension(vector.x()), new SimpleScreenDimension(vector.y()));
	}
	
	public ScreenDimension2d() {
		this(new SimpleScreenDimension(), new SimpleScreenDimension());
	}
	
	public ScreenDimension2d recalculate(Vector2ic screenSize, Vector2fc fatherSize) {
		xAxis.recalculate(screenSize, fatherSize, SimpleScreenDimension.X_AXIS);
		xAxis.recalculate(screenSize, fatherSize, SimpleScreenDimension.Y_AXIS);
		return this;
	}
	
	
	public ScreenDimension2d reset() {
		xAxis.reset();
		yAxis.reset();
		return this;
	}
	
	public SimpleScreenDimension getXAxis() {
		return xAxis;
	}
	
	public SimpleScreenDimension getYAxis() {
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

	public ScreenDimension2d applyX(VoidTask<SimpleScreenDimension> screenDimension) {
		screenDimension.runVoid(xAxis);
		return this;
	}
	
	public ScreenDimension2d applyY(VoidTask<SimpleScreenDimension> screenDimension) {
		screenDimension.runVoid(yAxis);
		return this;
	}
	
	public ScreenDimension2d apply(VoidTask<SimpleScreenDimension> screenDimension) {
		screenDimension.runVoid(xAxis);
		screenDimension.runVoid(yAxis);
		return this;
	}
	
	public ScreenDimension2d add(ScreenDimension2d dimension2d) {
		xAxis.add(dimension2d.getXAxis());
		yAxis.add(dimension2d.getYAxis());
		return this;
	}
	
	public ScreenDimension2d remove(ScreenDimension2d dimension2d) {
		xAxis.remove(dimension2d.getXAxis());
		yAxis.remove(dimension2d.getYAxis());
		return this;
	}
	
	public ScreenDimension2d addPF(float percentageOfFather) {
		this.xAxis.addPF(percentageOfFather);
		this.yAxis.addPF(percentageOfFather);
		return this;
	}
	
	public ScreenDimension2d removePF(float percentageOfFather) {
		this.xAxis.removePF(percentageOfFather);
		this.yAxis.removePF(percentageOfFather);
		return this;
	}
	
	public ScreenDimension2d addPW(float percentageOfWindow) {
		this.xAxis.addPW(percentageOfWindow);
		this.yAxis.addPW(percentageOfWindow);
		return this;
	}
	
	public ScreenDimension2d removePW(float percentageOfWindow) {
		this.xAxis.removePW(percentageOfWindow);
		this.yAxis.removePW(percentageOfWindow);
		return this;
	}
	

}
