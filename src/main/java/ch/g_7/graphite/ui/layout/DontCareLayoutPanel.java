package ch.g_7.graphite.ui.layout;

import ch.g_7.graphite.ui.IUIPanel;
import ch.g_7.graphite.ui.UIPanel;

public class DontCareLayoutPanel extends UIPanel {
	
	@Override
	public void add(IUIPanel panel) {
		super.add(panel);
		place(panel);
	}
	
	public void remove(IUIPanel panel) {
		super.remove(panel);
	}
	
	private void place(IUIPanel panel) {
		panel.getMaxWidth().reset().addPF(100).remove(panel.getX());
		panel.getMaxHeight().reset().addPF(100).remove(panel.getY());
	
		panel.getMinWidth().reset();
		panel.getMinHeight().reset();
		
		requestRecalculation(this);
	}

	
}
