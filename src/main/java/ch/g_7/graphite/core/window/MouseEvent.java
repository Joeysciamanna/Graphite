package ch.g_7.graphite.core.window;

public class MouseEvent {

	private int button;
	private int action;
	private int mods;

	private int x;
	private int y;

	public MouseEvent(int button, int action, int mods, int x, int y) {
		this.button = button;
		this.action = action;
		this.mods = mods;
		this.x = x;
		this.y = y;
	}


	public int getButton() {
		return button;
	}

	public int getAction() {
		return action;
	}

	public int getMods() {
		return mods;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
