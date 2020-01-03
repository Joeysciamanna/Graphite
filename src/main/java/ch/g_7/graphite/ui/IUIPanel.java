package ch.g_7.graphite.ui;

import ch.g_7.graphite.rendering.BasicRenderable;
import ch.g_7.graphite.ui.util.ScreenDimension;

public interface IUIPanel extends IUIContainer, BasicRenderable{

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
