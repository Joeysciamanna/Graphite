package ch.g_7.graphite.xtest;

import org.joml.Vector3f;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.mesh.AbstractMesh;
import ch.g_7.graphite.entity.mesh.MeshBuilder;
import ch.g_7.graphite.entity.mesh.MeshFactory;
import ch.g_7.graphite.entity.object.BasicObject;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.UIRootContainer;
import ch.g_7.graphite.entity.ui.layout.CenterLayoutPanel;
import ch.g_7.graphite.entity.ui.layout.DontCareLayoutPanel;
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
		
//		UIPanel panel2 = new UIPanel();
//		panel2.getPreferedWidth().reset().addPF(50);
//		panel2.getPreferedHeight().reset().addPF(50);
//		panel2.getX().addPF(12.5f);
//		panel2.getY().addPF(12.5f);
//		panel2.setColor(new Color(255, 0, 0, 100));
//		inventory.add(panel2);
		
		DontCareLayoutPanel layoutPanel = new DontCareLayoutPanel();
		layoutPanel.getPreferedWidth().reset().addPF(100);
		layoutPanel.getPreferedHeight().reset().addPF(50);
//		layoutPanel.setColor(new Color(255, 0, 0, 200));
		inventory.add(layoutPanel);
		
		UIPanel panel1 = new UIPanel();
		panel1.getPreferedWidth().reset().addPF(25);
		panel1.getPreferedHeight().reset().addPF(50);
		panel1.setColor(new Color(0, 255, 0, 200));
		layoutPanel.add(panel1);
		

		inventory.recalculate();
		
		
//		AbstractMesh mesh1 = MeshFactory.getSquare(1).setCenter(MeshBuilder.CENTER_MIDDLE).build();
//		BasicViewModel viewModel1 = new BasicViewModel(new Color(255, 155, 0, 100), mesh1);
//		BasicObject object1 = new BasicObject(viewModel1, new Vector3f());
//		object1.setPosition(new Vector3f(0, 0, 0.9f));
//		getDimension().addObj(object1, RenderClass.BASIC_GAME_OBJECTS);
//		
//		AbstractMesh mesh2 = MeshFactory.getSquare(1).setCenter(MeshBuilder.CENTER_TOP_LEFT).build();
//		BasicViewModel viewModel2 = new BasicViewModel(new Color(0, 155, 0, 100), mesh2);
//		BasicObject object2 = new BasicObject(viewModel2, new Vector3f());
//		getDimension().addObj(object2, RenderClass.BASIC_GAME_OBJECTS);
		
	
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
		

	

}
