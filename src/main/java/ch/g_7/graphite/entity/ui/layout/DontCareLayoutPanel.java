package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.dimension.SimpleScreenDimension;

public class DontCareLayoutPanel extends UIPanel {
	
	private List<IUIPanel> childs;
	
	public DontCareLayoutPanel() {
		this.childs = new ArrayList<>();
	}
	
	@Override
	public void recalculateDimensions(Vector2ic screenSize) {
		super.recalculateDimensions(screenSize);
	}
	
	public void add(IUIPanel panel) {
		childs.add(panel);
		panel.setFather(this);
		place(panel);
	}
	
	public void remove(IUIPanel panel) {
		childs.remove(panel);
	}
	
	private void place(IUIPanel panel) {
		panel.getMaxSize().reset().addPF(100).remove(panel.getPosition());
		panel.getMinSize().reset();
		
		requestDimensionRecalculation(this);
	}

	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}
	
}
