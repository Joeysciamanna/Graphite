package ch.g_7.graphite.xtest;

import org.joml.Vector3f;

import ch.g_7.graphite.base.entity.BasicEntity;
import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.MeshBuilder;
import ch.g_7.graphite.base.mesh.MeshFactory;
import ch.g_7.graphite.base.ui.ScreenDimension;
import ch.g_7.graphite.base.ui.UIPanel;
import ch.g_7.graphite.base.ui.UIRootContainer;
import ch.g_7.graphite.base.ui.layout.ListPanel;
import ch.g_7.graphite.base.viewmodel.BasicViewModel;
import ch.g_7.graphite.core.Application;
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
	
	protected void init() {
		UIRootContainer inventory = new UIRootContainer(getWindow());
		
		ListPanel listPanel = new ListPanel(ListPanel.Y_AXIS);
		listPanel.getHeight().addPF(100);
		listPanel.getWidth().addPW(50);
		inventory.add(listPanel);
		inventory.recalculate();
		
		listPanel.setBorderLeft(new ScreenDimension().addPF(5));
		listPanel.setBorderTop(new ScreenDimension().addPixel(100));
		listPanel.setSpaceHolder(new ScreenDimension().addPF(7.5f));
		
		
		UIPanel panel1 = new UIPanel();
		panel1.setColor(new Color(0, 255, 0, 0));
		panel1.getHeight().addPF(25);
		panel1.getWidth().addPF(90);
		listPanel.add(panel1);
		
		UIPanel panel2 = new UIPanel();
		panel2.setColor(new Color(255, 0, 0, 0));
		panel2.getHeight().addPF(25);
		panel2.getWidth().addPF(90);
		listPanel.add(panel2);

		UIPanel panel3 = new UIPanel();
		panel3.setColor(new Color(0, 0, 255, 0));
		panel3.getHeight().addPF(25);
		panel3.getWidth().addPF(90);
		listPanel.add(panel3);
		
		getDimension().addObj(inventory, RenderClass.UI_PANELS);
	
//		
//		
//		Mesh mesh2 = MeshFactory.getSquare(1).build();
//		BasicViewModel viewModel2 = new BasicViewModel(new Color(255, 0, 0, 0), mesh2);
//		BasicEntity gameObject = new BasicEntity(viewModel2, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject, RenderClass.BASIC_GAME_OBJECTS);
		
		
		Mesh mesh1 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_BUTTOM_LEFT).build();
		BasicViewModel viewModel1 = new BasicViewModel(new Color(255, 0, 0, 0), mesh1);
		BasicEntity gameObject1 = new BasicEntity(viewModel1, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject1, RenderClass.BASIC_GAME_OBJECTS);

		Mesh mesh2 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_BUTTOM_RIGHT).build();
		BasicViewModel viewModel2 = new BasicViewModel(new Color(0, 255, 0, 0), mesh2);
		BasicEntity gameObject2 = new BasicEntity(viewModel2, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject2, RenderClass.BASIC_GAME_OBJECTS);
		
//		Mesh mesh3 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_MIDDLE).build();
//		BasicViewModel viewModel3 = new BasicViewModel(new Color(0, 0, 255, 0), mesh3);
//		BasicEntity gameObject3 = new BasicEntity(viewModel3, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject3, RenderClass.BASIC_GAME_OBJECTS);
		
		Mesh mesh4 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_TOP_LEFT).build();
		BasicViewModel viewModel4 = new BasicViewModel(new Color(255, 255, 0, 0), mesh4);
		BasicEntity gameObject4 = new BasicEntity(viewModel4, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject4, RenderClass.BASIC_GAME_OBJECTS);
		
		Mesh mesh5 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_TOP_RIGHT).build();
		BasicViewModel viewModel5 = new BasicViewModel(new Color(0, 0, 255, 0), mesh5);
		BasicEntity gameObject5 = new BasicEntity(viewModel5, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject5, RenderClass.BASIC_GAME_OBJECTS);
//		
//		System.out.println("\n\n");
//		System.out.println("\n\n");
		
//		Mesh mesh = new SquareMesh(0.5f);

	
		
		
	
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);

	}
		

	

}
