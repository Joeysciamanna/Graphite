package ch.g_7.graphite.xtest;

import org.joml.Vector3f;

import ch.g_7.graphite.base.entity.BasicGameObject;
import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.SquareMesh;
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
		Mesh mesh = new SquareMesh(0.5f);
		BasicViewModel viewModel = new BasicViewModel(new Color(255, 0, 0, 0), mesh);
		BasicGameObject gameObject = new BasicGameObject(viewModel, new Vector3f(0, 0, 0));
		getDimension().addObj(gameObject, RenderClass.BASIC_GAME_OBJECTS);
		getWindow().setVisible(true);
	}
	
	
	
	

}
