package ch.g_7.graphite.xtest;

import org.joml.Vector3f;

import ch.g_7.graphite.base.mesh.BasicMesh3d;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.node.RenderCluster;
import ch.g_7.graphite.node.entity.BasicEntity;
import ch.g_7.graphite.node.entity.ViewModel;
import ch.g_7.graphite.rendering.entity.EntityTransformation3d;
import ch.g_7.graphite.ui.UIButton;
import ch.g_7.graphite.ui.UIPanel;
import ch.g_7.graphite.ui.UIRootContainer;
import ch.g_7.graphite.ui.layout.DontCareLayoutPanel;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.task.SecureRunner;

public class Test extends Application {

	public Test(String name) {
		super(name);
	}
	
	
	public static void main(String[] args) {
		new Test("Test App").setRunning(true);
	}
	

	BasicEntity entity1;
	BasicEntity entity2;
	
	@Override
	protected void initGame() {

		
		
		Texture square1 = new SecureRunner<Void, Texture>(()->new Texture("C:\\Users\\Joey Sciamanna\\git\\Graphite\\src\\main\\resources\\textures\\square.png")).get();
//		Texture square2 = new SecureRunner<Void, Texture>(()->new Texture("C:\\Users\\Joey Sciamanna\\git\\Graphite\\src\\main\\resources\\textures\\square2.png")).get();
		
		UIRootContainer inventory = new UIRootContainer(getWindow());
		getDimension().addObj(inventory, RenderCluster.UI);
		
		UIPanel panel2 = new UIPanel();
		panel2.getPreferedWidth().reset().addPF(50);
		panel2.getPreferedHeight().reset().addPF(50);
		panel2.getX().addPF(12.5f);
		panel2.getY().addPF(12.5f);
		panel2.setColor(Color.getColor(0, 0, 0, 0));
		inventory.add(panel2);
		
		DontCareLayoutPanel layoutPanel = new DontCareLayoutPanel();
		layoutPanel.getPreferedWidth().reset().addPF(100);
		layoutPanel.getPreferedHeight().reset().addPF(50);
		layoutPanel.setColor(Color.getColor(255, 0, 0));
		inventory.add(layoutPanel);
		
		UIButton panel1 = new UIButton();
		panel1.getPreferedWidth().reset().addPF(25);
		panel1.getPreferedHeight().reset().addPF(50);
		panel1.setColor(Color.getColor(100, 100, 0));
		panel1.setTexture(square1);
		panel1.getX().addPF(12.5f);
		panel1.getY().addPF(12.5f);
		layoutPanel.add(panel1);
		
		panel1.getMaxHeight().addPF(200);
		panel1.getPreferedHeight().addPF(100);
		
		inventory.setVisible(false);

		float[] positions = new float[] {
			    // VO
			    -0.5f,  0.5f,  0.5f,
			    // V1
			    -0.5f, -0.5f,  0.5f,
			    // V2
			    0.5f, -0.5f,  0.5f,
			    // V3
			     0.5f,  0.5f,  0.5f,
			    // V4
			    -0.5f,  0.5f, -0.5f,
			    // V5
			     0.5f,  0.5f, -0.5f,
			    // V6
			    -0.5f, -0.5f, -0.5f,
			    // V7
			     0.5f, -0.5f, -0.5f,
			};
		int[] indices = new int[] {
			    // Front face
			    0, 1, 3, 3, 1, 2,
			    // Top Face
			    4, 0, 3, 5, 4, 3,
			    // Right face
			    3, 2, 7, 5, 3, 7,
			    // Left face
			    6, 1, 0, 6, 0, 4,
			    // Bottom face
			    2, 1, 6, 2, 6, 7,
			    // Back face
			    7, 6, 4, 7, 4, 5,
			};
	    ViewModel viewModel = new ViewModel();
		viewModel.setMesh(new BasicMesh3d(positions, indices));
//		viewModel.setTexture(square1);
		viewModel.setColor(Color.getColor(255, 255, 0));
		
		entity1 = new BasicEntity();
		entity1.setViewModel(viewModel);
		entity1.setPosition(new Vector3f(0, 0, -2));
		RenderCluster.ENTITIES.getRenderer().setTransformation(new EntityTransformation3d());
		getDimension().addObj(entity1, RenderCluster.ENTITIES);
//		
		
//		IMesh2d mesh2 = MeshFactory2d.getSquare(1).setCenter(MeshyBuilder2d.CENTER_MIDDLE).build();
//		entity2 = new BasicEntity();
//		entity2.setTexture(square2);
//		entity2.setMesh(mesh2);
//		entity2.setPosition(new Vector3f(0, 0, -2f));
//		getDimension().addObj(entity2, RenderClass.ENTITIES_3D);
//		
	
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
		

	@Override
	public void update(double deltaMillis) {
//		entity1.setScale((float) (entity1.getScale() + deltaMillis * 0.0001));
//		System.out.println(getTimer().getFPS());
		entity1.getRotation().x = (float) Math.toRadians(deltaMillis * 0.05 + Math.toDegrees(entity1.getRotation().x));
//		entity1.getRotation().y = (float) Math.toRadians(deltaMillis * 0.05 + Math.toDegrees(entity1.getRotation().y));
//		entity1.getRotation().z = (float) Math.toRadians(deltaMillis * 0.05 + Math.toDegrees(entity1.getRotation().z));
//		Vector3f position = new Vector3f();
//		entity1.getPosition().mul(1.1f, 1.1f, 1.1f, position);
//		entity1.setPosition(position);
//		System.out.println(getTimer().calculateFPS());

	}
	

}
