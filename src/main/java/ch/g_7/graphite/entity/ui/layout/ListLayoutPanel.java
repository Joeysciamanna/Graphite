package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension;

public class ListLayoutPanel extends UIPanel {

	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;
	
	private ScreenDimension placeHolder;
	
	private byte axis;
	
	private ScreenDimension nextPos;
	
	private List<IUIPanel> childs;

	
	public ListLayoutPanel(byte axis) {
		this.axis = axis;
		this.childs = new ArrayList<>();
		this.placeHolder = new ScreenDimension(axis);
		this.nextPos = new ScreenDimension(axis);
	}
	
	
	@Override
	public void recalculateDimensions(Vector2ic screenSize) {
		recalculateDimension(placeHolder, screenSize);
		recalculateDimension(nextPos, screenSize);
		super.recalculateDimensions(screenSize);
	}
	
	
	public void add(IUIPanel panel) {
		childs.add(panel);
		panel.setFather(this);
		place(panel);
	}
	
	
	private void place(IUIPanel panel) {
		panel.getMaxWidth().reset().addPF(100);
		panel.getMaxHeight().reset().addPF(100);
		panel.getMinWidth().reset();
		panel.getMinHeight().reset();
		panel.getX().reset();
		panel.getY().reset();
		//TODO possible pass by reference issue
		if(axis == X_AXIS) {
			panel.getX().add(nextPos);
			nextPos.add(panel.getWidth()).add(placeHolder);
		} else {
			panel.getY().add(nextPos);
			nextPos.add(panel.getHeight()).add(placeHolder);
		}
		requestDimensionRecalculation(this);
	}
	
	
	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}
	
	public ScreenDimension getSpaceHolder() {
		return placeHolder;
	}
}
