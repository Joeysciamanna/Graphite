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
		mainPanel.close();
		mainPanel = null;
	}

	public void removeAdjustablePanel() {
		childs.remove(adjustablePanel);
		adjustablePanel.close();
		adjustablePanel = null;
	}

	public void setMainPanel(IUIPanel mainPanel, byte stickySide) {
		if (this.mainPanel != null) {
			removeMainPanel();
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
		case LEFT:
			mainPanel.getMinHeight().addPF(100);
			break;
		case TOP:
			mainPanel.getMinWidth().addPF(100);
			break;
		case RIGHT:
			mainPanel.getMinHeight().addPF(100);
			mainPanel.getX().addPF(100).remove(mainPanel.getWidth());
			break;
		case BUTTOM:
			mainPanel.getMinWidth().addPF(100);
			mainPanel.getY().addPF(100).remove(mainPanel.getHeight());
			break;
		}
		mainPanelPosition = stickySide;
		requestRecalculation(this);
	}
	
	public void setAdjustablePanel(IUIPanel adjustablePanel) {
		if (this.adjustablePanel != null) {
			removeAdjustablePanel();
		}
		this.adjustablePanel = adjustablePanel;
		childs.add(adjustablePanel);
		adjustablePanel.setFather(this);
		placeAdjustablePanel(adjustablePanel);
	}


	private void placeAdjustablePanel(IUIPanel adjustablePanel) {
		adjustablePanel.getMaxWidth().reset().addPF(100);
		adjustablePanel.getMaxHeight().reset().addPF(100);
		adjustablePanel.getMinWidth().reset().addPF(100);
		adjustablePanel.getMinHeight().reset().addPF(100);
		adjustablePanel.getX().reset();
		adjustablePanel.getY().reset();
		

		switch (mainPanelPosition) {
		case TOP:
			adjustablePanel.getMaxHeight().remove(mainPanel.getHeight());
			adjustablePanel.getMaxHeight().remove(mainPanel.getHeight());
			
			adjustablePanel.getY().add(mainPanel.getHeight());
			break;
		case BUTTOM:
			adjustablePanel.getMaxHeight().remove(mainPanel.getHeight());
			adjustablePanel.getMaxHeight().remove(mainPanel.getHeight());
			
			adjustablePanel.getY().addPF(100).remove(mainPanel.getHeight()).remove(adjustablePanel.getWidth());
			break;
		case LEFT:
			adjustablePanel.getMaxWidth().remove(mainPanel.getWidth());
			adjustablePanel.getMinWidth().remove(mainPanel.getWidth());
			
			adjustablePanel.getX().add(mainPanel.getWidth());
			break;
		case RIGHT:
			adjustablePanel.getMaxWidth().remove(mainPanel.getWidth());
			adjustablePanel.getMinWidth().remove(mainPanel.getWidth());
			
			adjustablePanel.getX().addPF(100).remove(mainPanel.getWidth()).remove(adjustablePanel.getWidth());
			break;
		}
		requestRecalculation(this);
	}

	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}

}
