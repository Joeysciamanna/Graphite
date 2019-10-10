package ch.g_7.graphite.base.ui.layout;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.base.ui.UIPanel;

public class AligementLayoutPanel extends UIPanel {
	
	public static final byte TOP_LEFT = 0;
	public static final byte TOP_RIGHT = 1;
	public static final byte BUTTON_LEFT = 2;

	
	private IUIPanel[] childs;
	private List<IUIPanel> childList;
	
	
	public AligementLayoutPanel() {
		this.childs = new IUIPanel[3];
		this.childList = new ArrayList<>();
	}
	
	public void add(IUIPanel panel, byte position) {
		if(childs[position] != null) {
			childList.remove(childs[position]);
		}
		childs[position] = panel;
		childList.add(panel);
		panel.setFather(this);
		place(panel, position);
	}
	

	public void remove(byte position) {
		IUIPanel panel = childs[position];
		childs[position] = null;
		childList.remove(panel);
	}

	private void place(IUIPanel panel, byte position) {
		switch (position) {
		case TOP_LEFT:
			panel.getX().reset();
			panel.getY().reset();
		break;
		case TOP_RIGHT:
			panel.getX().reset().addPF(100).remove(panel.getWidth());
			panel.getY().reset();
		break;
		case BUTTON_LEFT:
			panel.getX().reset();
			panel.getY().reset().addPF(100).remove(panel.getHeight());
		break;
		}
		requestRecalculation(this);
	}
	
	@Override
	public List<IUIPanel> getChilds() {
		return childList;
	}

}
