package ch.g_7.graphite.xtest;

import org.joml.Vector3f;

import ch.g_7.graphite.base.entity.BasicEntity;
import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.MeshBuilder;
import ch.g_7.graphite.base.mesh.MeshFactory;
import ch.g_7.graphite.base.ui.UIPanel;
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
		UIPanel uiPanel = new UIPanel();
		
		uiPanel.getWidth().setPercentageOfWindow(10);
		uiPanel.getHeight().setPercentageOfWindow(94);
		
		uiPanel.getX().setPercentageOfWindow(2);
		uiPanel.getY().setPercentageOfWindow(2);

		
		getDimension().addObj(uiPanel, RenderClass.UI_PANELS);
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
		
		Mesh mesh3 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_MIDDLE).build();
		BasicViewModel viewModel3 = new BasicViewModel(new Color(0, 0, 255, 0), mesh3);
		BasicEntity gameObject3 = new BasicEntity(viewModel3, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject3, RenderClass.BASIC_GAME_OBJECTS);
		
		Mesh mesh4 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_TOP_LEFT).build();
		BasicViewModel viewModel4 = new BasicViewModel(new Color(255, 255, 0, 0), mesh4);
		BasicEntity gameObject4 = new BasicEntity(viewModel4, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject4, RenderClass.BASIC_GAME_OBJECTS);
		
		Mesh mesh5 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_TOP_RIGHT).build();
		BasicViewModel viewModel5 = new BasicViewModel(new Color(255, 0, 255, 0), mesh5);
		BasicEntity gameObject5 = new BasicEntity(viewModel5, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject5, RenderClass.BASIC_GAME_OBJECTS);
//		
//		System.out.println("\n\n");
//		System.out.println("\n\n");
		
//		Mesh mesh = new SquareMesh(0.5f);

	
		
		
		
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
		uiPanel.recalculate(getWindow().getSize());
	}
	
	

	

}
