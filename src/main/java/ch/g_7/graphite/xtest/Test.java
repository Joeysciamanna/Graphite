package ch.g_7.graphite.xtest;

import org.joml.Vector2f;
import org.joml.Vector3f;

import ch.g_7.graphite.base.entity.BasicGameObject;
import ch.g_7.graphite.base.mesh.Mesh;
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
		Mesh mesh1 = MeshFactory.getRegular(4, 0.5f).centerTopLeft().build();
		BasicViewModel viewModel1 = new BasicViewModel(new Color(255, 0, 0, 0), mesh1);
		UIPanel uiPanel = new UIPanel(viewModel1, new Vector2f(0, 0));
		getDimension().addObj(uiPanel, RenderClass.UI_PANELS);
		
		
		Mesh mesh2 = MeshFactory.getRegular(4, 0.5f).build();
		BasicViewModel viewModel2 = new BasicViewModel(new Color(255, 0, 0, 0), mesh2);
		BasicGameObject gameObject = new BasicGameObject(viewModel2, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject, RenderClass.BASIC_GAME_OBJECTS);
//		
//		Mesh mesh2 = MeshFactory.getRegular(7, 0.3f).center().build();
//		BasicViewModel viewModel2 = new BasicViewModel(new Color(0, 255, 0, 0), mesh2);
//		BasicGameObject gameObject2 = new BasicGameObject(viewModel2, new Vector3f(0, 0, 0));
//		getDimension().addObj(gameObject2, RenderClass.BASIC_GAME_OBJECTS);
//		
//		System.out.println("\n\n");
//		System.out.println("\n\n");
		
//		Mesh mesh = new SquareMesh(0.5f);

	
		
		
		
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
	
	

	

}
