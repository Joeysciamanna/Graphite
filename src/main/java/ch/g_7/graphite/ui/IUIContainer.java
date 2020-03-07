package ch.g_7.graphite.ui;

import java.util.List;

import org.joml.Vector2ic;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.ui.util.ScreenDimension;

public interface IUIContainer extends INode {

	boolean isVisible();

	List<IUIPanel> getChilds();

	void recalculate();
	
	void recalculate(Vector2ic screenSize, Vector2ic fatherSize);
	
	void requestRecalculation(IUIContainer container);
	
	Window getWindow();
	
	ScreenDimension getWidth();
	ScreenDimension getHeight();
	Vector2ic getSize();
	
	ScreenDimension getX();
	ScreenDimension getY();
	Vector2ic getPosition();
	
	ITransformation2d getTransformation();
	
	IUIRootContainer getRootContainer();
}
