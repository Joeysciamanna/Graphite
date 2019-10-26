package ch.g_7.graphite.entity.ui.dimension;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

public interface IROScreenDimension2d {

	
	public ScreenDimension2d recalculate(Vector2ic screenSize, Vector2fc fatherSize);
	
	public IROScreenDimension getXAxis();
	
	public IROScreenDimension getYAxis();
	
	public float getXValue();

	public float getYValue();
	
	public Vector2fc toVector();
}
