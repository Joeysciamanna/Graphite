package ch.g_7.graphite.entity.ui.util;

import ch.g_7.graphite.core.window.MouseEvent;
import ch.g_7.graphite.entity.ui.IUIButton;
import ch.g_7.graphite.entity.ui.IUIContainer;
import ch.g_7.graphite.entity.ui.IUIPanel;

public class UIMouseEvent extends MouseEvent {

	private IUIPanel buttonPanel;
	private boolean fromLocalSource;
	
	public UIMouseEvent(long window, IUIPanel buttonPanel, int button, int action, int mods, int x, int y) {
		super(window, button, action, mods, x, y);
		this.buttonPanel = buttonPanel;
	}
	
	public UIMouseEvent(MouseEvent event, IUIPanel buttonPanel) {
		this(event.getWindow(), buttonPanel, event.getButton(), event.getAction(), event.getMods(), event.getX(), event.getY());
	}

	public IUIPanel getButtonPanel() {
		return buttonPanel;
	}

}
