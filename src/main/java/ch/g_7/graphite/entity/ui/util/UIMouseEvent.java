package ch.g_7.graphite.entity.ui.util;

import ch.g_7.graphite.entity.ui.IUIButton;

public class UIMouseEvent {

	private int button;
	private int mods;
	private float x;
	private float y;
	private IUIButton buttonPanel;
	private boolean fromLocalSource;


	public UIMouseEvent(int button, int mods, float x, float y) {
		this.button = button;
		this.mods = mods;
		this.x = x;
		this.y = y;
	}

	protected void setButtonPanel(IUIButton buttonPanel) {
		this.buttonPanel = buttonPanel;
	}
	
	protected void setFromLocalSource(boolean fromLocalSource) {
		this.fromLocalSource = fromLocalSource;
	}
	
	public IUIButton getButtonPanel() {
		return buttonPanel;
	}

	public boolean isFromLocalSource() {
		return fromLocalSource;
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public int getButton() {
		return button;
	}

	public int getMods() {
		return mods;
	}

}
