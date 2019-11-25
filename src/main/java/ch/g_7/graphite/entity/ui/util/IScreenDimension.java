package ch.g_7.graphite.entity.ui.util;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public interface IScreenDimension {

	
	public IScreenDimension recalculate(Vector2ic screenSize, Vector2fc fatherSize);
	
	public IScreenDimension recalculate(int screenSize, float fatherSize);
	
	public float getValue();

}
