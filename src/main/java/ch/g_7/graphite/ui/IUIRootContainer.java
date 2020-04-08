package ch.g_7.graphite.ui;//package ch.g_7.graphite.ui;

import ch.g_7.graphite.core.window.ResizeListner;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.IEntity;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.ui.util.MouseManager;

public interface IUIRootContainer extends IUIContainer, ResizeListner, IEntity<IViewModel, IUIPanel> {

	void add(IUIPanel panel);

	void remove(IUIPanel panel);

	void clear();

	Window getWindow();

	MouseManager getMouseManager();

}
