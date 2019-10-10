package ch.g_7.graphite.base.ui.layout;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.base.ui.UIPanel;

public class DontCareLayoutPanel extends UIPanel {

	private List<IUIPanel> childs;
	
	public DontCareLayoutPanel() {
		this.childs = new ArrayList<>();
	}
	
	public void add(IUIPanel panel) {
		childs.add(panel);
		panel.setFather(this);
		requestRecalculation(this);
	}
	
	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}
}
