package ch.g_7.graphite.ui;

import java.io.Closeable;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.util.ScreenDimension;
import ch.g_7.util.able.Initializable;

public interface IUIContainer extends Initializable, Closeable {

	boolean isVisible();

	List<IUIPanel> getChilds();

	void recalculate();
	
	void recalculate(Vector2ic screenSize, Vector2ic fatherSize);
	
	void requestRecalculation(IUIContainer container);
	
	void init();
	
	@Override
	void close();
	


	Window getWindow();
	
	ScreenDimension getWidth();
	ScreenDimension getHeight();
	Vector2ic getSize();
	
	ScreenDimension getX();
	ScreenDimension getY();
	Vector2ic getPosition(); //TODO
	
	IUIRootContainer getRootContainer();
}
