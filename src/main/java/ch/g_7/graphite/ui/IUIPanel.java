package ch.g_7.graphite.ui;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.ui.util.ScreenDimension;
import ch.g_7.graphite.util.Color;

public interface IUIPanel extends IUIContainer {

	void setFather(IUIContainer container);
	
	IUIContainer getFather();
	
	void recalculatePreferedSize();

	Color getColor();
	
	Texture getTexture();
	
	IMesh getMesh();
	
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
