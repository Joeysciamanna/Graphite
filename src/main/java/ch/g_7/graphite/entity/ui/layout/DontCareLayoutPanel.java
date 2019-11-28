package ch.g_7.graphite.entity.ui.layout;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.util.ScaledScreenDimension;

public class DontCareLayoutPanel extends UIPanel {
	
	
	
	@Override
	public void add(IUIPanel panel) {
		super.add(panel);
		place(panel);
	}
	
	@Override
	public void remove(IUIPanel panel) {
		super.remove(panel);
	}
	
	private void place(IUIPanel panel) {
//		panel.getMaxWidth().reset().addPF(100).remove(panel.getX());
//		panel.getMaxHeight().reset().addPF(100).remove(panel.getY());
//	
//		panel.getMinWidth().reset();
//		panel.getMinHeight().reset();
		panel.getMaxWidth().reset().addPF(100);
		panel.getMaxHeight().reset().addPF(100);
		panel.getMinWidth().reset();
		panel.getMinHeight().reset();
		
		panel.getX().reset().addPF(50).remove(new ScaledScreenDimension(panel.getWidth(), 0.5f));
		panel.getY().reset().addPF(50).remove(new ScaledScreenDimension(panel.getHeight(), 0.5f));
		requestRecalculation(this);
	}

	
}
