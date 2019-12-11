package ch.g_7.graphite.math.shape2d;

import java.util.List;

import ch.g_7.graphite.math.vector.IVector2dInt;

public interface IPloygonInt {

	public int getCornerCount();
	
	public List<IVector2dInt> getCorners();
	
	public boolean contains(IVector2dInt point);
	
	
}
