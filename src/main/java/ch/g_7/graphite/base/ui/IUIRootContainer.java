package ch.g_7.graphite.base.ui;

import ch.g_7.graphite.base.ui.util.MouseManager;
import ch.g_7.graphite.core.window.ResizeListner;

public interface IUIRootContainer extends IUIContainer, ResizeListner {

	void add(IUIPanel panel);
	
	void remove(IUIPanel panel);
	
	void clear();
	
	MouseManager getMouseManager();

}
