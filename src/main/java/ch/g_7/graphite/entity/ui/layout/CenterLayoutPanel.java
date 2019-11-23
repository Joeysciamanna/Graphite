package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.dimension.ScaledScreenDimension;

public class CenterLayoutPanel extends UIPanel{
	
	private List<IUIPanel> childs;
	
	public CenterLayoutPanel() {
		this.childs = new ArrayList<>(1);
	}
	
	
	
	public void set(IUIPanel panel) {
		clear();
		childs.add(panel);
		panel.setFather(this);
		place(panel);
		panel.init();
	}
	
	private void place(IUIPanel panel) {
		panel.getMaxWidth().reset().addPF(100);
		panel.getMaxHeight().reset().addPF(100);
		panel.getMinWidth().reset();
		panel.getMinHeight().reset();
		
		panel.getX().addPF(50).remove(new ScaledScreenDimension(panel.getWidth(), 0.5f));
		panel.getY().addPF(50).remove(new ScaledScreenDimension(panel.getHeight(), 0.5f));
		
		requestRecalculation(this);
	}
	
	public void clear() {
		if(!childs.isEmpty()) {
			childs.get(0).close();
			childs.clear();
		}
	}
	
	
	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}
	
}
