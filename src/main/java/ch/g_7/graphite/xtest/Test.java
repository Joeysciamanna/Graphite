package ch.g_7.graphite.xtest;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.UIRootContainer;
import ch.g_7.graphite.entity.ui.layout.GridLayoutPanel;
import ch.g_7.graphite.rendering.RenderClass;
import ch.g_7.graphite.util.Color;

public class Test extends Application {

	public Test(String name) {
		super(name);
	}
	
	
	public static void main(String[] args) {
		new Test("Test App").setRunning(true);
	}
	

	@Override
	
	protected void initGame() {
		
		
		UIRootContainer inventory = new UIRootContainer(getWindow());
		getDimension().addObj(inventory, RenderClass.UI);

//		SpaceSharingLayoutPanel sharingLayoutPanel = new SpaceSharingLayoutPanel();
//		sharingLayoutPanel.getPreferedWidth().reset().addPF(100);
//		sharingLayoutPanel.getPreferedHeight().reset().addPF(100);
//		inventory.add(sharingLayoutPanel);
//		
//		UIPanel panel1 = new UIPanel();
//		panel1.setColor(new Color(0, 255, 0, 0));
//		panel1.getPreferedWidth().reset().addPixel(30);
//		panel1.getPreferedHeight().reset().addPixel(30);
//		sharingLayoutPanel.setMainPanel(panel1, SpaceSharingLayoutPanel.BUTTOM);
//
//		
//		UIPanel panel2 = new UIPanel();
//		panel2.setColor(new Color(255, 0, 0, 0));
//		panel2.getPreferedWidth().reset().addPF(50);
//		panel2.getPreferedHeight().reset().addPF(50);;
//		sharingLayoutPanel.setAdjustablePanel(panel2);


		
//		AligementLayoutPanel aligementLayoutPanel = new AligementLayoutPanel();
//		aligementLayoutPanel.getPreferedWidth().reset().addPF(100);
//		aligementLayoutPanel.getPreferedHeight().reset().addPF(100);
//		inventory.add(aligementLayoutPanel);
//		
//		UIPanel panel1 = new UIPanel();
//		panel1.setColor(new Color(0, 255, 0, 0));
//		panel1.getPreferedWidth().reset().addPW(50);
//		panel1.getPreferedHeight().reset().addPW(50);
//		aligementLayoutPanel.add(panel1, AligementLayoutPanel.BUTTOM);
//		
//		UIPanel panel2 = new UIPanel();
//		panel2.setColor(new Color(255, 255, 0, 0));
//		panel2.getPreferedWidth().reset().addPixel(50);
//		panel2.getPreferedHeight().reset().addPW(50);
//		aligementLayoutPanel.add(panel2, AligementLayoutPanel.RIGHT);
		
		
		
//		CenterLayoutPanel centerLayoutPanel = new CenterLayoutPanel();
//		centerLayoutPanel.getPreferedWidth().reset().addPW(100);
//		centerLayoutPanel.getPreferedHeight().reset().addPW(100);
//		inventory.add(centerLayoutPanel);
//		
//		UIPanel panel1 = new UIPanel();
//		panel1.setColor(new Color(0, 255, 0, 0));
//		panel1.getPreferedWidth().reset().addPixel(20);
//		panel1.getPreferedHeight().reset().addPW(50);
//		centerLayoutPanel.set(panel1);

		
		
		
		int height = 5;
		int width = 5;
		GridLayoutPanel gridLayoutPanel = new GridLayoutPanel(width, height);
		gridLayoutPanel.getPreferedWidth().reset().addPW(100);
		gridLayoutPanel.getPreferedHeight().reset().addPF(100);
//		gridLayoutPanel.getColumCellPlaceHolder().reset().addPixel(1);
//		gridLayoutPanel.getRowsCellPlaceHolder().reset().addPixel(1);
		inventory.add(gridLayoutPanel);
		
		for (int x = 0; x<width; x++) {
			for(int y = 0; y<height; y++) {
				UIPanel panel1 = new UIPanel();
				panel1.setColor(new Color((255/(3*height))*x, (255/(3*width))*y, 255/(x+y+1), 0));
				gridLayoutPanel.add(panel1, x, y);
			}
		}


		
	
		
		
//		ListLayoutPanel listPanel = new ListLayoutPanel(ListLayoutPanel.Y_AXIS);
//		listPanel.getPreferedHeight().reset().addPF(100);
//		listPanel.getPreferedWidth().reset().addPW(100);
//		inventory.add(listPanel);
//		
//		listPanel.getPlaceHolder().addPixel(10);
//		
//		
//		UIPanel panel1 = new UIPanel();
//		panel1.setColor(new Color(255, 255, 0, 0));
//		panel1.getPreferedHeight().reset().addPF(25);
//		panel1.getPreferedWidth().addPF(90);
//		listPanel.add(panel1);
//		
//		UIPanel panel2 = new UIPanel();
//		panel2.setColor(new Color(255, 0, 0, 0));
//		panel2.getPreferedHeight().reset().addPF(25);
//		panel2.getPreferedWidth().addPF(90);
//		listPanel.add(panel2);
//
//		UIPanel panel3 = new UIPanel();
//		panel3.setColor(new Color(0, 0, 255, 0));
//		panel3.getPreferedHeight().reset().addPF(25);
//		panel3.getPreferedWidth().addPF(90);
//		listPanel.add(panel3);


		
	
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);

	}
		

	

}
