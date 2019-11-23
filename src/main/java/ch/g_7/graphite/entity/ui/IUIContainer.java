package ch.g_7.graphite.entity.ui;

import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension;
import ch.g_7.graphite.rendering.Renderable;

public interface IUIContainer extends Renderable {

	boolean isVisible();

	List<IUIPanel> getChilds();

	void recalculate(Vector2ic screenSize);
	
	void recalculate();
	
	void requestDimensionRecalculation(IUIContainer container);

	Window getWindow();
	
	
	ScreenDimension getWidth();
	ScreenDimension getHeight();
	Vector2fc getSize();
	
	ScreenDimension getX();
	ScreenDimension getY();
	Vector2fc getPosition();
	
}
