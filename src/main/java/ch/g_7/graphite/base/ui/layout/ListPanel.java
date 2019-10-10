package ch.g_7.graphite.base.ui.layout;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2ic;

import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.base.ui.ScreenDimension;
import ch.g_7.graphite.base.ui.UIPanel;

public class ListPanel extends UIPanel {

	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;
	
	
	private ScreenDimension borderLeft;
	private ScreenDimension borderTop;
	private ScreenDimension spaceHolder;
	
	private byte axis;
	
	private ScreenDimension nextPos;
	
	private List<IUIPanel> childs;

	
	public ListPanel(byte axis) {
		this.axis = axis;
		this.childs = new ArrayList<>();
		this.borderLeft = new ScreenDimension();
		this.borderTop = new ScreenDimension();
		this.spaceHolder = new ScreenDimension();
		this.nextPos = new ScreenDimension();
	}
	
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		recalculateDimension(borderLeft, screenSize, X_AXIS);
		recalculateDimension(borderTop, screenSize, Y_AXIS);	
		recalculateDimension(spaceHolder, screenSize, axis);
		recalculateDimension(nextPos, screenSize, axis);
		super.recalculate(screenSize);
	}
	
	
	public void add(UIPanel panel) {
		childs.add(panel);
		panel.setFather(this);
		place(panel);
	}
	
	
	private void place(UIPanel panel) {
		if(axis == X_AXIS) {
			panel.getY().reset();
			panel.getX().reset().add(nextPos);
			nextPos.add(panel.getWidth()).add(spaceHolder);
		} else {
			panel.getX().reset();
			panel.getY().reset().add(nextPos);
			nextPos.add(panel.getHeight()).add(spaceHolder);
		}
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
	
	public void setBorderLeft(ScreenDimension borderLeft) {
		this.borderLeft = borderLeft;
	}
	
	public ScreenDimension getBorderTop() {
		return borderTop;
	}
	
	public void setBorderTop(ScreenDimension borderTop) {
		this.borderTop = borderTop;
	}
	
	public ScreenDimension getSpaceHolder() {
		return spaceHolder;
	}
	
	public void setSpaceHolder(ScreenDimension spaceHolder) {
		this.spaceHolder = spaceHolder;
	}
}
