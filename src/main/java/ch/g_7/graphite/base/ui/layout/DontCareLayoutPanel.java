package ch.g_7.graphite.base.ui.layout;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2ic;

import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.base.ui.ScreenDimension;
import ch.g_7.graphite.base.ui.UIPanel;

public class DontCareLayoutPanel extends UIPanel {

	private ScreenDimension borderLeft;
	private ScreenDimension borderTop;
	
	private List<IUIPanel> childs;
	
	public DontCareLayoutPanel() {
		this.childs = new ArrayList<>();
		this.borderLeft = new ScreenDimension();
		this.borderTop = new ScreenDimension();
	}
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		recalculateDimension(borderLeft, screenSize, ScreenDimension.X_AXIS);
		recalculateDimension(borderTop, screenSize, ScreenDimension.Y_AXIS);
		super.recalculate(screenSize);
	}
	
	public void add(IUIPanel panel) {
		childs.add(panel);
		panel.setFather(this);
		place(panel);
	}
	
	private void place(IUIPanel panel) {
		panel.getX().add(borderLeft);
		panel.getY().add(borderTop);
		requestRecalculation(this);
	}

	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}
	
	public ScreenDimension getBorderLeft() {
		return borderLeft;
	}
	
	public ScreenDimension getBorderTop() {
		return borderTop;
	}
}
