package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.dimension.ScaledScreenDimension;

public class CenterLayoutPanel extends UIPanel{
	
	private List<IUIPanel> child;
	
	public CenterLayoutPanel() {
		this.child = new ArrayList<>(1);
	}
	
	
	
	public void set(IUIPanel panel) {
		if(!child.isEmpty()) {
			child.clear();
		}
		child.add(panel);
		panel.setFather(this);
		place(panel);
	}
	
	private void place(IUIPanel panel) {
		panel.getMaxSize().reset().addPF(100);
		panel.getMinSize().reset();

		panel.getPosition().reset().addPF(50)
			.applyX((s)->s.remove(new ScaledScreenDimension(panel.getSize().getXAxis(), 0.5f)))
			.applyY((s)->s.remove(new ScaledScreenDimension(panel.getSize().getYAxis(), 0.5f)));
		
		requestDimensionRecalculation(this);
	}
	
	
	@Override
	public List<IUIPanel> getChilds() {
		return child;
	}
	
}
