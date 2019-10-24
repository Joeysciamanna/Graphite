package ch.g_7.graphite.entity.ui;

import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.rendering.Renderable;

public interface IUIContainer extends Renderable {

	boolean isVisible();

	List<IUIPanel> getChilds();

	void recalculate(Vector2ic screenSize);
	
	void requestRecalculation(IUIContainer container);

	Vector2fc getSize();

	Vector2fc getPosition();
	
	ScreenDimension getWidth();
	
	ScreenDimension getHeight();
	
	ScreenDimension getX();
	
	ScreenDimension getY();
}
