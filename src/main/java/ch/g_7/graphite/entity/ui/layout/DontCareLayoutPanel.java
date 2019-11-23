package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;

public class DontCareLayoutPanel extends UIPanel {
	
	private List<IUIPanel> childs;
	
	public DontCareLayoutPanel() {
		this.childs = new ArrayList<>();
	}
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		super.recalculate(screenSize);
	}
	
	public void add(IUIPanel panel) {
		childs.add(panel);
		panel.setFather(this);
		place(panel);
		panel.init();
	}
	
	public void remove(IUIPanel panel) {
		childs.remove(panel);
		panel.close();
	}
	
	private void place(IUIPanel panel) {
		panel.getMaxWidth().addPF(100).remove(panel.getX());
		panel.getMaxHeight().addPF(100).remove(panel.getY());
	
		panel.getMinWidth().reset();
		panel.getMinHeight().reset();
		
		requestRecalculation(this);
	}

	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}
	
}
