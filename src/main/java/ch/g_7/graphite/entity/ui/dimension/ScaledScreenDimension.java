package ch.g_7.graphite.entity.ui.dimension;

import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public class ScaledScreenDimension implements IROScreenDimension{

	
	private IROScreenDimension dimension;
	private float factor;

	public ScaledScreenDimension(IROScreenDimension dimension, float factor) {
		this.dimension = dimension;
		this.factor = factor;
	}
	
	public void setFactor(float factor) {
		this.factor = factor;
	}

	@Override
	public ScaledScreenDimension recalculate(Vector2ic screenSize, Vector2fc fatherSize, byte axis) {
		dimension.recalculate(screenSize, fatherSize, axis);
		return this;
	}

	@Override
	public ScaledScreenDimension recalculate(int screenSize, float fatherSize) {
		dimension.recalculate(screenSize, fatherSize);
		return this;
	}

	@Override
	public float getValue() {
		return dimension.getValue() * factor;
	}



	
	
}
