package ch.g_7.graphite.xtest;

import org.joml.Vector3f;

import ch.g_7.graphite.base.entity.BasicEntity;
import ch.g_7.graphite.base.mesh.AbstractMesh;
import ch.g_7.graphite.base.mesh.MeshBuilder;
import ch.g_7.graphite.base.mesh.MeshFactory;
import ch.g_7.graphite.base.ui.UIButton;
import ch.g_7.graphite.base.ui.UIPanel;
import ch.g_7.graphite.base.ui.UIRootContainer;
import ch.g_7.graphite.base.ui.layout.DontCareLayoutPanel;
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
	
	protected void initGame() {
		
		getWindow().setBackgroundColor(new Color(0, 0, 0, 0));
		
		UIRootContainer inventory = new UIRootContainer(getWindow());
		getDimension().addObj(inventory, RenderClass.UI);
		
		UIPanel panel2 = new UIPanel();
		panel2.getPreferedWidth().reset().addPF(50);
		panel2.getPreferedHeight().reset().addPF(50);
		panel2.getX().addPF(12.5f);
		panel2.getY().addPF(12.5f);
		panel2.setColor(new Color(255, 0, 0, 0));
		inventory.add(panel2);
		
		DontCareLayoutPanel layoutPanel = new DontCareLayoutPanel();
		layoutPanel.getPreferedWidth().reset().addPF(100);
		layoutPanel.getPreferedHeight().reset().addPF(50);
		layoutPanel.setColor(new Color(200, 0, 55, 100));
		inventory.add(layoutPanel);
		
		UIButton panel1 = new UIButton();
		panel1.getPreferedWidth().reset().addPF(25);
		panel1.getPreferedHeight().reset().addPF(50);
		panel1.setColor(new Color(0, 255, 0, 100));
		panel1.getX().addPF(12.5f);
		panel1.getY().addPF(12.5f);
		layoutPanel.add(panel1);
		
		panel1.getMaxHeight().addPF(200);
		panel1.getPreferedHeight().addPF(100);
		
		inventory.recalculate();
		

		
		
		
		AbstractMesh mesh1 = MeshFactory.getSquare(1).setCenter(MeshBuilder.CENTER_MIDDLE).build();
		BasicEntity entity1 = new BasicEntity();
		entity1.setColor(new Color(255, 0, 0, 100));
		entity1.setMesh(mesh1);
		entity1.setPosition(new Vector3f(0, 0, 0f));
		getDimension().addObj(entity1, RenderClass.ENTITIES);
		
		
		AbstractMesh mesh2 = MeshFactory.getSquare(1).setCenter(MeshBuilder.CENTER_TOP_LEFT).build();
		BasicEntity entity2 = new BasicEntity();
		entity2.setColor(new Color(255, 255, 0, 100));
		entity2.setMesh(mesh2);
		entity2.setPosition(new Vector3f(0, 0, -0.2f));
		getDimension().addObj(entity2, RenderClass.ENTITIES);
		
	
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
		

	

}
