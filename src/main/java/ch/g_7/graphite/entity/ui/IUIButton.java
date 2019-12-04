package ch.g_7.graphite.entity.ui;

import ch.g_7.graphite.core.window.MouseEvent;
import ch.g_7.util.task.Task;

public interface IUIButton extends IUIPanel {

	void addClickListner(Task<ButtonAction, Void> buttonListner);
	
	void removeClickListner(Task<ButtonAction, Void> buttonListner);

	void clearClickListner();
	
	
	


}
