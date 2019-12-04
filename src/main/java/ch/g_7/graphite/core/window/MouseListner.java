package ch.g_7.graphite.core.window;

import ch.g_7.util.task.Task.VoidTask;

@FunctionalInterface
public interface MouseListner extends VoidTask<MouseEvent>{ 

	@Override
	default void runVoid(MouseEvent i) {
		onMouseClick(i);
	}
	
	void onMouseClick(MouseEvent i);

}
