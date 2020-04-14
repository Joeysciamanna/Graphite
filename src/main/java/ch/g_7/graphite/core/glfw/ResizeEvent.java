package ch.g_7.graphite.core.glfw;

import ch.g_7.graphite.input.IInputAction;
import ch.g_7.graphite.input.InputAction;
import ch.g_7.util.listener.StoreEvent;

public class ResizeEvent extends StoreEvent<IInputAction<?>> {

	private int width;
	private int height;
	
	
	public ResizeEvent(int width, int height) {
		super(InputAction.RESIZE);
		this.width = width;
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

	
}
