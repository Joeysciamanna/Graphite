package ch.g_7.graphite.base.ui;

import ch.g_7.graphite.base.ui.util.ScreenDimension;
import ch.g_7.graphite.rendering.Basic2dRenderable;

public interface IUIPanel extends IUIContainer, Basic2dRenderable{

	void setFather(IUIContainer container);
	
	IUIContainer getFather();
	
	void recalculateSize();
	
	void setResized(boolean resized);
	
	/**
	 * Set by system, only change if you now what you are doing
	 */
	ScreenDimension getMaxWidth();
	/**
	 * Set by system, only change if you now what you are doing
	 */
	ScreenDimension getMaxHeight();
	
	/**
	 * Set by system, only change if you now what you are doing
	 */
	ScreenDimension getMinWidth();
	/**
	 * Set by system, only change if you now what you are doing
	 */
	ScreenDimension getMinHeight();
	
	
	ScreenDimension getPreferedWidth();
	ScreenDimension getPreferedHeight();
	

}
