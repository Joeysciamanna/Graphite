package ch.g_7.graphite.ui;

import ch.g_7.graphite.core.window.ResizeListner;
import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.ui.util.MouseManager;

public interface IUIRootContainer extends IUIContainer, IEntity, ResizeListner {

	void add(IUIPanel panel);
	
	void remove(IUIPanel panel);
	
	void clear();
	
	MouseManager getMouseManager();

}
