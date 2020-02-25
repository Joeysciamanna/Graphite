package ch.g_7.graphite.ui.layout;

import ch.g_7.graphite.ui.IUIPanel;
import ch.g_7.graphite.ui.UIPanel;
import ch.g_7.graphite.ui.util.ScaledScreenDimension;

public class CenterLayoutPanel extends UIPanel{

	
	public void set(IUIPanel panel) {
		clear();
		super.add(panel);
		place(panel);
	}
	
	private void place(IUIPanel panel) {
		panel.getMaxWidth().reset().addPF(100);
		panel.getMaxHeight().reset().addPF(100);
		panel.getMinWidth().reset();
		panel.getMinHeight().reset();
		
		panel.getX().reset().addPF(50).remove(new ScaledScreenDimension(panel.getWidth(), 0.5f));
		panel.getY().reset().addPF(50).remove(new ScaledScreenDimension(panel.getHeight(), 0.5f));
		
		requestRecalculation(this);
	}
	
	public void clear() {
		super.clear();
	}
	
	
	
}
