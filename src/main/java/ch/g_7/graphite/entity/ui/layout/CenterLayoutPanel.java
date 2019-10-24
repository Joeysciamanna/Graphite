package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.ScreenDimension;
import ch.g_7.graphite.entity.ui.UIPanel;

public class CenterLayoutPanel extends UIPanel{

	private ScreenDimension borderLeft;
	private ScreenDimension borderTop;
	
	private List<IUIPanel> child;
	
	public CenterLayoutPanel() {
		this.borderLeft = new ScreenDimension();
		this.borderTop = new ScreenDimension();
		this.child = new ArrayList<>(1);
	}
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		recalculateDimension(borderLeft, screenSize, ScreenDimension.X_AXIS);
		recalculateDimension(borderTop, screenSize, ScreenDimension.Y_AXIS);
		super.recalculate(screenSize);
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
		panel.getX().reset().add(borderLeft).addPF(50).remove(panel.getWidth().clone().multiply(0.5f));
		panel.getY().reset().add(borderTop).addPF(50).remove(panel.getHeight().clone().multiply(0.5f));
		requestRecalculation(this);
	}
	
	
	@Override
	public List<IUIPanel> getChilds() {
		return child;
	}
	
	public ScreenDimension getBorderLeft() {
		return borderLeft;
	}
	
	public ScreenDimension getBorderTop() {
		return borderTop;
	}
}
