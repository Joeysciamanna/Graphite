package ch.g_7.graphite.entity.ui.dimension;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public interface IROScreenDimension {

	
	public AbstractScreenDimension recalculate(Vector2ic screenSize, Vector2fc fatherSize, byte axis);
	
	public AbstractScreenDimension recalculate(int screenSize, float fatherSize);
	
	public float getValue();

}
