package ch.g_7.graphite.math.shape2d;

import java.util.List;

import ch.g_7.graphite.math.vector.IVector2dFloat;

public interface IPloygonFloat {

	public int getCornerCount();
	
	public List<IVector2dFloat> getCorners();
	
	public boolean contains(IVector2dFloat point);
	
}
