package ch.g_7.graphite.xtest;

import org.joml.Vector3f;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.mesh.AbstractMesh;
import ch.g_7.graphite.entity.mesh.MeshBuilder;
import ch.g_7.graphite.entity.mesh.MeshFactory;
import ch.g_7.graphite.entity.object.BasicObject;
import ch.g_7.graphite.entity.viewmodel.BasicViewModel;
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
		
		
		

		
		
		
		
		
//		UIRootContainer inventory = new UIRootContainer(getWindow());
		
		
	
		
		
		
//		SpaceSharingLayoutPanel sharingLayoutPanel = new SpaceSharingLayoutPanel();
//		sharingLayoutPanel.getHeight().addPF(100);
//		sharingLayoutPanel.getWidth().addPW(100);
//		inventory.add(sharingLayoutPanel);
//		
//		UIPanel panel1 = new UIPanel();
//		panel1.setColor(new Color(0, 255, 0, 0));
//		panel1.getHeight().addPF(50);
//		panel1.getWidth().addPF(50);
//		sharingLayoutPanel.setMainPanel(panel1);
//		
//		UIPanel panel2 = new UIPanel();
//		panel2.setColor(new Color(255, 0, 0, 0));
//		panel2.getHeight().addPF(25);
//		panel2.getWidth().addPF(25);
//		sharingLayoutPanel.setAdjustablePanel(panel2, SpaceSharingLayoutPanel.Y_AXIS);
		
		
		
		
		
//		AligementLayoutPanel aligementLayoutPanel = new AligementLayoutPanel();
//		aligementLayoutPanel.getHeight().addPF(100);
//		aligementLayoutPanel.getWidth().addPW(100);
//		inventory.add(aligementLayoutPanel);
//		
//		UIPanel panel1 = new UIPanel();
//		panel1.setColor(new Color(0, 255, 0, 0));
//		panel1.getHeight().addPF(50);
//		panel1.getWidth().addPF(50);
//		aligementLayoutPanel.add(panel1, AligementLayoutPanel.TOP_RIGHT);
		
		
		
		
		
//		CenterLayoutPanel centerLayoutPanel = new CenterLayoutPanel();
//		centerLayoutPanel.getHeight().addPF(100);
//		centerLayoutPanel.getWidth().addPW(100);
//		centerLayoutPanel.getBorderLeft().addPF(25);
//		centerLayoutPanel.getBorderTop().addPF(25);
//		inventory.add(centerLayoutPanel);
//		
//		UIPanel panel1 = new UIPanel();
//		panel1.setColor(new Color(0, 255, 0, 0));
//		panel1.getHeight().addPF(50);
//		panel1.getWidth().addPF(50);
//		centerLayoutPanel.set(panel1);
		
		
		
		
//		int height = 5;
//		int width = 5;
//		GridLayoutPanel gridLayoutPanel = new GridLayoutPanel(width, height);
//		gridLayoutPanel.getHeight().addPF(100);
//		gridLayoutPanel.getWidth().addPW(100);
//		gridLayoutPanel.getColumCellPlaceHolder().addPF(1);
//		gridLayoutPanel.getRowsCellPlaceHolder().addPF(1);
//		inventory.add(gridLayoutPanel);
//		
//		for (int x = 0; x<width; x++) {
//			for(int y = 0; y<height; y++) {
//				UIPanel panel1 = new UIPanel();
//				panel1.setColor(new Color((255/(3*height))*x, (255/(3*width))*y, 255/(x+y+1), 0));
//				gridLayoutPanel.add(panel1, x, y);
//			}
//		}
//		UIPanel panel1 = new UIPanel();
//		panel1.setColor(new Color(255, 0 ,0 ,0));
//		gridLayoutPanel.add(panel1, 2, 2);
		
	
		
		
//		ListPanel listPanel = new ListPanel(ListPanel.Y_AXIS);
//		listPanel.getHeight().addPF(100);
//		listPanel.getWidth().addPW(50);
//		inventory.add(listPanel);
//		
//		listPanel.setBorderLeft(new ScreenDimension().addPF(5));
//		listPanel.setBorderTop(new ScreenDimension().addPixel(100));
//		listPanel.setSpaceHolder(new ScreenDimension().addPF(7.5f));
//		
//		
//		UIPanel panel1 = new UIPanel();
//		panel1.setColor(new Color(0, 255, 0, 0));
//		panel1.getHeight().addPF(25);
//		panel1.getWidth().addPF(90);
//		listPanel.add(panel1);
//		
//		UIPanel panel2 = new UIPanel();
//		panel2.setColor(new Color(255, 0, 0, 0));
//		panel2.getHeight().addPF(25);
//		panel2.getWidth().addPF(90);
//		listPanel.add(panel2);
//
//		UIPanel panel3 = new UIPanel();
//		panel3.setColor(new Color(0, 0, 255, 0));
//		panel3.getHeight().addPF(25);
//		panel3.getWidth().addPF(90);
//		listPanel.add(panel3);
		
//		getDimension().addObj(inventory, RenderClass.UI_PANELS);
	
//		
//		
//		Mesh mesh2 = MeshFactory.getSquare(1).build();
//		BasicViewModel viewModel2 = new BasicViewModel(new Color(255, 0, 0, 0), mesh2);
//		BasicEntity gameObject = new BasicEntity(viewModel2, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject, RenderClass.BASIC_GAME_OBJECTS);
		
		
		AbstractMesh mesh1 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_BUTTOM_LEFT).build();
		BasicViewModel viewModel1 = new BasicViewModel(new Color(255, 0, 0, 0), mesh1);
		BasicObject gameObject1 = new BasicObject(viewModel1, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject1, RenderClass.BASIC_GAME_OBJECTS);

		AbstractMesh mesh2 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_BUTTOM_RIGHT).build();
		BasicViewModel viewModel2 = new BasicViewModel(new Color(0, 255, 0, 0), mesh2);
		BasicObject gameObject2 = new BasicObject(viewModel2, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject2, RenderClass.BASIC_GAME_OBJECTS);
		
//		Mesh mesh3 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_MIDDLE).build();
//		BasicViewModel viewModel3 = new BasicViewModel(new Color(0, 0, 255, 0), mesh3);
//		BasicEntity gameObject3 = new BasicEntity(viewModel3, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject3, RenderClass.BASIC_GAME_OBJECTS);
		
		AbstractMesh mesh4 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_TOP_LEFT).build();
		BasicViewModel viewModel4 = new BasicViewModel(new Color(255, 255, 0, 0), mesh4);
		BasicObject gameObject4 = new BasicObject(viewModel4, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject4, RenderClass.BASIC_GAME_OBJECTS);
		
		AbstractMesh mesh5 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_TOP_RIGHT).build();
		BasicViewModel viewModel5 = new BasicViewModel(new Color(0, 0, 255, 0), mesh5);
		BasicObject gameObject5 = new BasicObject(viewModel5, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject5, RenderClass.BASIC_GAME_OBJECTS);
//		
//		System.out.println("\n\n");
//		System.out.println("\n\n");
		
//		Mesh mesh = new SquareMesh(0.5f);

	
		
		
	
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);

	}
		

	

}
