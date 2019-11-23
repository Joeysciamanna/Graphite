package ch.g_7.graphite.entity.ui;

import java.util.concurrent.CompletableFuture;

import ch.g_7.graphite.core.window.ResizeAction;
import ch.g_7.graphite.core.window.ResizeListner;
import ch.g_7.util.task.Task.AsyncTask;

public interface IUIRootContainer extends IUIContainer, ResizeListner {

	void add(IUIPanel panel);
	
	void remove(IUIPanel panel);
	
}
