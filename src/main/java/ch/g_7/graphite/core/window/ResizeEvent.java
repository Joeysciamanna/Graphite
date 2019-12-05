package ch.g_7.graphite.core.window;

public class ResizeEvent {

	private int width;
	private int height;
	
	
	public ResizeEvent(long window, int width, int height) {
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
