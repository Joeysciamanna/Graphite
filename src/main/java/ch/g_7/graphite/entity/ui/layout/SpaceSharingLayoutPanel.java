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
		mainPanel.getPosition().reset();
		mainPanel.getMaxSize().reset().addPF(100).remove(mainPanel.getPosition());
		mainPanel.getMinSize().reset();
		
		switch (stickySide) {
		case RIGHT:
			mainPanel.getPosition().getXAxis().addPF(100).remove(mainPanel.getSize().getXAxis());
			break;
		case BUTTOM:
			mainPanel.getPosition().getYAxis().addPF(100).remove(mainPanel.getSize().getYAxis());
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
		adjustablePanel.getPosition().reset();
		adjustablePanel.getMaxSize().reset().addPF(100).remove(mainPanel.getSize());
		adjustablePanel.getMinSize().reset();

		switch (mainPanelPosition) {
		case TOP:
			adjustablePanel.getPosition().getYAxis().add(mainPanel.getSize().getYAxis());
			break;
		case BUTTOM:
			adjustablePanel.getPosition().getYAxis().addPF(100).remove(mainPanel.getSize().getYAxis());
			break;
		case LEFT:
			adjustablePanel.getPosition().getXAxis().add(mainPanel.getSize().getXAxis());
			break;
		case RIGHT:
			adjustablePanel.getPosition().getXAxis().addPF(100).remove(mainPanel.getSize().getXAxis());
			break;
		}
		requestDimensionRecalculation(this);
	}

	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}

}
