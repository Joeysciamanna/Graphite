package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;

public class AligementLayoutPanel extends UIPanel {

	public static final byte TOP = 0;
	public static final byte LEFT = 1;
	public static final byte RIGHT = 2;
	public static final byte BUTTOM = 3;

	private IUIPanel[] childs;
	private List<IUIPanel> childList;

	public AligementLayoutPanel() {
		this.childs = new IUIPanel[3];
		this.childList = new ArrayList<>();
	}

	public void add(IUIPanel panel, byte position) {
		if (childs[position] != null) {
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
		panel.getMaxSize().reset().addPF(100);
		panel.getMinSize().reset();
		panel.getPosition().reset();
		switch (position) {
		case TOP:
			break;
		case LEFT:
			break;
		case RIGHT:
			panel.getPosition().applyX((s)->s.addPF(100).remove(panel.getSize().getXAxis()));
		break;
		case BUTTOM:
			panel.getPosition().applyY((s)->s.addPF(100).remove(panel.getSize().getYAxis()));
		break;
		}
		requestRecalculation(this);
	}
	
	@Override
	public List<IUIPanel> getChilds() {
		return childList;
	}

}
