package ch.g_7.graphite.core.window;

import ch.g_7.util.task.Task.VoidTask;

@FunctionalInterface
public interface ResizeListner extends VoidTask<ResizeEvent>{

	@Override
	default void runVoid(ResizeEvent action) {
		onResize(action);
	}
	
	void onResize(ResizeEvent action);
}
