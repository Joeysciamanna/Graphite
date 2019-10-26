package ch.g_7.graphite.entity.ui;

import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.ui.dimension.IROScreenDimension2d;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension2d;
import ch.g_7.graphite.rendering.Renderable;

public interface IUIContainer extends Renderable {

	boolean isVisible();

	List<IUIPanel> getChilds();

	void recalculate(Vector2ic screenSize);
	
	void requestRecalculation(IUIContainer container);

	Window getWindow();
	
	
	ScreenDimension2d getPosition();
	
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
	
	/**
	 * Calculated by System
	 */
	IROScreenDimension2d getSize();
	
	
}
