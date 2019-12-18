package ch.g_7.graphite.core.window;

import java.util.function.Consumer;

@FunctionalInterface
public interface ResizeListner extends Consumer<ResizeEvent>{

	@Override
	default void accept(ResizeEvent action) {
		onResize(action);
	}
	
	void onResize(ResizeEvent action);
}
