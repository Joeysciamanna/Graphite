package ch.g_7.graphite.ui.layout;

import ch.g_7.graphite.ui.IUIPanel;
import ch.g_7.graphite.ui.UIPanel;

public class AligementLayoutPanel extends UIPanel {

	public static final byte TOP = 0;
	public static final byte LEFT = 1;
	public static final byte RIGHT = 2;
	public static final byte BUTTOM = 3;

	private IUIPanel[] childs;

	public AligementLayoutPanel() {
		this.childs = new IUIPanel[4];
	}

	public void add(IUIPanel panel, byte position) {
		if (childs[position] != null) {
			remove(position);
		}
		childs[position] = panel;
		super.add(panel);
		place(panel, position);
	}

	public void remove(byte position) {
		IUIPanel panel = childs[position];
		childs[position] = null;
		super.remove(panel);
	}

	private void place(IUIPanel panel, byte position) {
		panel.getMaxWidth().reset().addPF(100);
		panel.getMaxHeight().reset().addPF(100);
		panel.getMinWidth().reset();
		panel.getMinHeight().reset();
		panel.getX().reset();
		panel.getY().reset();
		switch (position) {
		case TOP:
			break;
		case LEFT:
			break;
		case RIGHT:
			panel.getX().addPF(100).remove(panel.getWidth());
		break;
		case BUTTOM:
			panel.getY().addPF(100).remove(panel.getHeight());
		break;
		}
		requestRecalculation(this);
	}
	

}
