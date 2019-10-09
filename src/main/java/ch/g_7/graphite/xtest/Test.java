package ch.g_7.graphite.xtest;

import ch.g_7.graphite.base.ui.UIPanel;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.rendering.RenderClass;

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
		
		uiPanel.getWidth().setPercentageOfWindow(50);
		uiPanel.getHeight().setPercentageOfWindow(50).setPercentageOfFather(25);
		
		uiPanel.getX().setPercentageOfWindow(25);
//		uiPanel.getY().setPercentageOfWindow(50);

		uiPanel.recalculate(getWindow().getSize());
		getDimension().addObj(uiPanel, RenderClass.UI_PANELS);
//		
//		
//		Mesh mesh2 = MeshFactory.getSquare(1).build();
//		BasicViewModel viewModel2 = new BasicViewModel(new Color(255, 0, 0, 0), mesh2);
//		BasicGameObject gameObject = new BasicGameObject(viewModel2, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject, RenderClass.BASIC_GAME_OBJECTS);
		
		
//		Mesh mesh1 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_BUTTOM_LEFT).build();
//		BasicViewModel viewModel1 = new BasicViewModel(new Color(255, 0, 0, 0), mesh1);
//		BasicGameObject gameObject1 = new BasicGameObject(viewModel1, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject1, RenderClass.BASIC_GAME_OBJECTS);
//
//		Mesh mesh2 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_BUTTOM_RIGHT).build();
//		BasicViewModel viewModel2 = new BasicViewModel(new Color(0, 255, 0, 0), mesh2);
//		BasicGameObject gameObject2 = new BasicGameObject(viewModel2, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject2, RenderClass.BASIC_GAME_OBJECTS);
//		
//		Mesh mesh3 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_MIDDLE).build();
//		BasicViewModel viewModel3 = new BasicViewModel(new Color(0, 0, 255, 0), mesh3);
//		BasicGameObject gameObject3 = new BasicGameObject(viewModel3, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject3, RenderClass.BASIC_GAME_OBJECTS);
//		
//		Mesh mesh4 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_TOP_LEFT).build();
//		BasicViewModel viewModel4 = new BasicViewModel(new Color(255, 255, 0, 0), mesh4);
//		BasicGameObject gameObject4 = new BasicGameObject(viewModel4, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject4, RenderClass.BASIC_GAME_OBJECTS);
//		
//		Mesh mesh5 = MeshFactory.getRegular(4, 0.3f).setCenter(MeshBuilder.CENTER_TOP_RIGHT).build();
//		BasicViewModel viewModel5 = new BasicViewModel(new Color(255, 0, 255, 0), mesh5);
//		BasicGameObject gameObject5 = new BasicGameObject(viewModel5, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject5, RenderClass.BASIC_GAME_OBJECTS);
//		
//		System.out.println("\n\n");
//		System.out.println("\n\n");
		
//		Mesh mesh = new SquareMesh(0.5f);

	
		
		
		
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
	
	

	

}
