package ch.g_7.graphite.base.ui.layout;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.base.ui.UIPanel;

public class SpaceSharingLayoutPanel extends UIPanel {

	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;

	private List<IUIPanel> childs;

	private IUIPanel mainPanel;
	private IUIPanel adjustablePanel;

	public SpaceSharingLayoutPanel() {
		this.childs = new ArrayList<>();
	}

	public void removeMainPanel() {
		childs.remove(mainPanel);
		mainPanel = null;
	}

	public void removeAdjustablePanel() {
		childs.remove(adjustablePanel);
		adjustablePanel = null;
	}

	public void setMainPanel(IUIPanel mainPanel) {
		if (this.mainPanel != null) {
			childs.remove(this.mainPanel);
		}
		this.mainPanel = mainPanel;
		childs.add(mainPanel);
		mainPanel.setFather(this);
		placeMainPanel(mainPanel);
	}

	public void setAdjustablePanel(IUIPanel adjustablePanel, byte stickyAxis) {
		if (this.adjustablePanel != null) {
			childs.remove(this.adjustablePanel);
		}
		this.adjustablePanel = adjustablePanel;
		childs.add(adjustablePanel);
		adjustablePanel.setFather(this);
		placeAdjustablePanel(adjustablePanel, stickyAxis);
	}

	private void placeMainPanel(IUIPanel mainPanel) {
		mainPanel.getX().reset();
		mainPanel.getY().reset();
		requestRecalculation(this);
	}

	private void placeAdjustablePanel(IUIPanel adjustablePanel, byte stickyAxis) {
		adjustablePanel.getWidth().reset().addPF(100);
		adjustablePanel.getHeight().reset().addPF(100);
		adjustablePanel.getX().reset();
		adjustablePanel.getY().reset();
		switch (stickyAxis) {
		case X_AXIS:
			adjustablePanel.getX().add(mainPanel.getWidth());
			adjustablePanel.getWidth().remove(mainPanel.getWidth());
			break;
		case Y_AXIS:
			adjustablePanel.getY().add(mainPanel.getHeight());
			adjustablePanel.getHeight().remove(mainPanel.getHeight());
			break;
		}
		requestRecalculation(this);
	}

	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}

}
