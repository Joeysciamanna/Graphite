package ch.g_7.graphite.core.window;

import ch.g_7.util.task.Task.VoidTask;

public interface ResizeListner extends VoidTask<ResizeAction>{

	@Override
	default void runVoid(ResizeAction action) {
		onResize(action);
	}
	
	void onResize(ResizeAction action);
}
