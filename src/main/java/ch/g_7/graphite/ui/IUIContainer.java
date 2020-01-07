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

	void recalculate(Vector2ic screenSize);
	
	void recalculate();
	
	void init();
	
	@Override
	void close();
	
	void requestRecalculation(IUIContainer container);

	Window getWindow();
	
	ScreenDimension getWidth();
	ScreenDimension getHeight();
	Vector2fc getSize();
	
	ScreenDimension getX();
	ScreenDimension getY();
	Vector2fc getPosition(); //TODO
	
	IUIRootContainer getRootContainer();
}
