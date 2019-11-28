package ch.g_7.graphite.entity.ui;

import ch.g_7.graphite.core.window.ResizeListner;

public interface IUIRootContainer extends IUIContainer, ResizeListner {

	void add(IUIPanel panel);
	
	void remove(IUIPanel panel);
	
	void clear();
	
}
