package ch.g_7.graphite.core.window;

import ch.g_7.util.listner.IEvent;

public class KeyEvent implements IEvent {
	
	private int key;
	private int scancode;
	private int action; 
	private int mods;
	
	public KeyEvent(int key, int scancode, int action, int mods) {
		this.key = key;
		this.scancode = scancode;
		this.action = action;
		this.mods = mods;
	}

	
	public int getKey() {
		return key;
	}
	
	public int getScancode() {
		return scancode;
	}
	
	public int getAction() {
		return action;
	}
	
	public int getMods() {
		return mods;
	}

}
