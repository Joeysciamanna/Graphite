package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.dimension.SimpleScreenDimension;

public class ListLayoutPanel extends UIPanel {

	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;
	
	private SimpleScreenDimension placeHolder;
	
	private byte axis;
	
	private SimpleScreenDimension nextPos;
	
	private List<IUIPanel> childs;

	
	public ListLayoutPanel(byte axis) {
		this.axis = axis;
		this.childs = new ArrayList<>();
		this.placeHolder = new SimpleScreenDimension();
		this.nextPos = new SimpleScreenDimension();
	}
	
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		recalculateDimension(placeHolder, screenSize, axis);
		recalculateDimension(nextPos, screenSize, axis);
		super.recalculate(screenSize);
	}
	
	
	public void add(IUIPanel panel) {
		childs.add(panel);
		panel.setFather(this);
		place(panel);
	}
	
	
	private void place(IUIPanel panel) {
		panel.getPosition().reset();
		panel.getMinSize().reset();
		panel.getMaxSize().reset().addPF(100);
		if(axis == X_AXIS) {
			panel.getPosition().getXAxis().add(nextPos);
			nextPos.add(panel.getSize().getXAxis()).add(placeHolder);
		} else {
			panel.getPosition().getYAxis().add(nextPos);
			nextPos.add(panel.getSize().getYAxis()).add(placeHolder);
		}
		requestRecalculation(this);
	}
	
	
	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}
	
	public SimpleScreenDimension getSpaceHolder() {
		return placeHolder;
	}
}
