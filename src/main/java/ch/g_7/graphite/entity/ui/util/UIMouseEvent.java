package ch.g_7.graphite.entity.ui.util;

import ch.g_7.graphite.core.window.MouseEvent;
import ch.g_7.graphite.entity.ui.IUIButton;

public class UIMouseEvent extends MouseEvent {

	private IUIButton buttonPanel;
	private boolean fromLocalSource;
	
	
	public UIMouseEvent(MouseEvent event, IUIButton buttonPanel, boolean fromLocalSource) {
		super(event.getWindow(), event.getButton(), event.getAction(), event.getMods(), event.getX(), event.getY());
		this.buttonPanel = buttonPanel;
		this.fromLocalSource = fromLocalSource;
	}

	public IUIButton getButtonPanel() {
		return buttonPanel;
	}

	public boolean isFromLocalSource() {
		return fromLocalSource;
	}
}
