package ch.g_7.graphite.entity.ui;

import ch.g_7.graphite.entity.mesh.AbstractMesh;
import ch.g_7.graphite.entity.texture.Texture;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension2d;
import ch.g_7.graphite.util.Color;

public interface IUIPanel extends IUIContainer {

	AbstractMesh getMesh();

	Color getColor();

	Texture getTexture();

	void setFather(IUIContainer container);
	
	IUIContainer getFather();
	
	
	/**
	 * Set by system
	 */
	ScreenDimension2d getMaxSize();
	
	/**
	 * Set by system
	 */
	ScreenDimension2d getMinSize();
	
	/**
	 * Set by User
	 */
	ScreenDimension2d getPreferedSize();
	
}
