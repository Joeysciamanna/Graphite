package ch.g_7.graphite.entity.ui;

import ch.g_7.graphite.core.window.ResizeAction;
import ch.g_7.graphite.core.window.ResizeListner;
import ch.g_7.util.task.Task.AsyncTask;

public interface IUIRootContainer extends IUIContainer, ResizeListner, AsyncTask<ResizeAction> {

	void add(IUIPanel panel);
	
	void remove(IUIPanel panel);
	
	void recalculate();

	@Override
	default void runVoid(ResizeAction action) {
		AsyncTask.super.runVoid(action);
	}

	@Override
	default void runAsync(ResizeAction action) {
		onResize(action);
	}

}
