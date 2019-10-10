package ch.g_7.graphite.base.ui;

import ch.g_7.graphite.core.ResizeListner;

public interface IUIRootContainer extends IUIContainer, ResizeListner {

	void add(IUIPanel panel);
	
	void remove(IUIPanel panel);
	
	void recalculate();
}
