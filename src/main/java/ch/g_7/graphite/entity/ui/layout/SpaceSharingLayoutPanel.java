package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;

public class SpaceSharingLayoutPanel extends UIPanel {

	public static final byte TOP = 0;
	public static final byte LEFT = 1;
	public static final byte RIGHT = 2;
	public static final byte BUTTOM = 3;
	
	
	private List<IUIPanel> childs;

	private IUIPanel mainPanel;
	private byte mainPanelPosition;
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

	public void setMainPanel(IUIPanel mainPanel, byte stickySide) {
		if (this.mainPanel != null) {
			childs.remove(this.mainPanel);
		}
		this.mainPanel = mainPanel;
		childs.add(mainPanel);
		mainPanel.setFather(this);
		placeMainPanel(mainPanel, stickySide);
	}


	private void placeMainPanel(IUIPanel mainPanel, byte stickySide) {
		mainPanel.getMaxWidth().reset().addPF(100);
		mainPanel.getMaxHeight().reset().addPF(100);
		mainPanel.getMinWidth().reset();
		mainPanel.getMinHeight().reset();
		mainPanel.getX().reset();
		mainPanel.getY().reset();

		switch (stickySide) {
		case RIGHT:
			mainPanel.getX().addPF(100).remove(mainPanel.getWidth());
			break;
		case BUTTOM:
			mainPanel.getY().addPF(100).remove(mainPanel.getHeight());
			break;
		}
		mainPanelPosition = stickySide;
		requestDimensionRecalculation(this);
	}
	
	public void setAdjustablePanel(IUIPanel adjustablePanel) {
		if (this.adjustablePanel != null) {
			childs.remove(this.adjustablePanel);
		}
		this.adjustablePanel = adjustablePanel;
		childs.add(adjustablePanel);
		adjustablePanel.setFather(this);
		placeAdjustablePanel(adjustablePanel);
	}


	private void placeAdjustablePanel(IUIPanel adjustablePanel) {
		adjustablePanel.getMaxWidth().reset().addPF(100).remove(mainPanel.getWidth());
		adjustablePanel.getMaxHeight().reset().addPF(100).remove(mainPanel.getHeight());
		adjustablePanel.getMinWidth().reset();
		adjustablePanel.getMinHeight().reset();
		adjustablePanel.getX().reset();
		adjustablePanel.getY().reset();
		

		switch (mainPanelPosition) {
		case TOP:
			adjustablePanel.getY().add(mainPanel.getHeight());
			break;
		case BUTTOM:
			adjustablePanel.getY().addPF(100).remove(mainPanel.getHeight());
			break;
		case LEFT:
			adjustablePanel.getX().add(mainPanel.getWidth());
			break;
		case RIGHT:
			adjustablePanel.getX().addPF(100).remove(mainPanel.getWidth());
			break;
		}
		requestDimensionRecalculation(this);
	}

	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}

}
