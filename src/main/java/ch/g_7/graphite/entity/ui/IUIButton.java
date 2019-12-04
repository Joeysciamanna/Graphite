package ch.g_7.graphite.entity.ui;

import ch.g_7.graphite.core.window.MouseAction;
import ch.g_7.util.task.Task;

public interface IUIButton extends IUIPanel {

	void addClickListner(Task<ButtonAction, Void> buttonListner);
	
	void removeClickListner(Task<ButtonAction, Void> buttonListner);

	void clearClickListner();
	
	
	
	public static class ButtonAction extends MouseAction {

		private IUIButton buttonPanel;
		public ButtonAction(long window, IUIButton buttonPanel, int button, int action, int mods, int x, int y) {
			super(window, button, action, mods, x, y);
			this.buttonPanel = buttonPanel;
		}
		
		public IUIButton getButtonPanel() {
			return buttonPanel;
		}
	}

}
