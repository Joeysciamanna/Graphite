package ch.g_7.graphite.entity.ui;

import ch.g_7.graphite.entity.mesh.AbstractMesh;
import ch.g_7.graphite.entity.texture.Texture;
import ch.g_7.graphite.entity.ui.util.ScreenDimension;
import ch.g_7.graphite.util.Color;

public interface IUIPanel extends IUIContainer {

	AbstractMesh getMesh();

	Color getColor();

	Texture getTexture();

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

	void setLevel(int indexOf);
}
