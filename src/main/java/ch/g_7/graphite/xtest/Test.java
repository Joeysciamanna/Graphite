package ch.g_7.graphite.xtest;

import org.joml.Vector3f;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.mesh.AbstractMesh;
import ch.g_7.graphite.entity.mesh.MeshBuilder;
import ch.g_7.graphite.entity.mesh.MeshFactory;
import ch.g_7.graphite.entity.object.BasicObject;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.UIRootContainer;
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
		
		UIRootContainer inventory = new UIRootContainer(getWindow());
		getDimension().addObj(inventory, RenderClass.UI);
		
		
		UIPanel panel = new UIPanel();
		panel.setColor(new Color(100, 0, 0, 100));
		inventory.add(panel);
		inventory.setVisible(true);
	
		
		AbstractMesh mesh1 = MeshFactory.getSquare(1).setCenter(MeshBuilder.CENTER_MIDDLE).build();
		BasicViewModel viewModel1 = new BasicViewModel(new Color(255, 155, 0, 0), mesh1);
		BasicObject object1 = new BasicObject(viewModel1, new Vector3f());
		
		
		getDimension().addObj(object1, RenderClass.BASIC_GAME_OBJECTS);
	
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
		

	

}
