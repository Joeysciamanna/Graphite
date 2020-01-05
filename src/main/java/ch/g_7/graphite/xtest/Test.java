package ch.g_7.graphite.xtest;

import org.joml.Vector3f;

import ch.g_7.graphite.base.mesh.BasicMesh;
import ch.g_7.graphite.base.mesh.IMesh2d;
import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.BasicEntity;
import ch.g_7.graphite.rendering.RenderClass;
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
		Texture square2 = new SecureRunner<Void, Texture>(()->new Texture("C:\\Users\\Joey Sciamanna\\git\\Graphite\\src\\main\\resources\\textures\\square2.png")).get();
		
		UIRootContainer inventory = new UIRootContainer(getWindow());
		getDimension().addObj(inventory, RenderClass.UI);
		
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
				// V0
				-0.5f, 0.5f, 0.5f,
				// V1
				-0.5f, -0.5f, 0.5f,
				// V2
				0.5f, -0.5f, 0.5f,
				// V3
				0.5f, 0.5f, 0.5f,
				// V4
				-0.5f, 0.5f, -0.5f,
				// V5
				0.5f, 0.5f, -0.5f,
				// V6
				-0.5f, -0.5f, -0.5f,
				// V7
				0.5f, -0.5f, -0.5f,

				// For text coords in top face
				// V8: V4 repeated
				-0.5f, 0.5f, -0.5f,
				// V9: V5 repeated
				0.5f, 0.5f, -0.5f,
				// V10: V0 repeated
				-0.5f, 0.5f, 0.5f,
				// V11: V3 repeated
				0.5f, 0.5f, 0.5f,

				// For text coords in right face
				// V12: V3 repeated
				0.5f, 0.5f, 0.5f,
				// V13: V2 repeated
				0.5f, -0.5f, 0.5f,

				// For text coords in left face
				// V14: V0 repeated
				-0.5f, 0.5f, 0.5f,
				// V15: V1 repeated
				-0.5f, -0.5f, 0.5f,

				// For text coords in bottom face
				// V16: V6 repeated
				-0.5f, -0.5f, -0.5f,
				// V17: V7 repeated
				0.5f, -0.5f, -0.5f,
				// V18: V1 repeated
				-0.5f, -0.5f, 0.5f,
				// V19: V2 repeated
				0.5f, -0.5f, 0.5f, 
		};
		float[] textCoords = new float[] { 0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f, 0.5f, 0.0f,

				0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f,

				// For text coords in top face
				0.0f, 0.5f, 0.5f, 0.5f, 0.0f, 1.0f, 0.5f, 1.0f,

				// For text coords in right face
				0.0f, 0.0f, 0.0f, 0.5f,

				// For text coords in left face
				0.5f, 0.0f, 0.5f, 0.5f,

				// For text coords in bottom face
				0.5f, 0.0f, 1.0f, 0.0f, 0.5f, 0.5f, 1.0f, 0.5f, 
		};
		int[] indices = new int[] {
				// Front face
				0, 1, 3, 3, 1, 2,
				// Top Face
				8, 10, 11, 9, 8, 11,
				// Right face
				12, 13, 7, 5, 12, 7,
				// Left face
				14, 15, 6, 4, 14, 6,
				// Bottom face
				16, 18, 19, 17, 16, 19,
				// Back face
				4, 6, 7, 5, 4, 7, 
		};
	           
	    
		IMesh2d mesh1 = new BasicMesh(positions, indices, textCoords);
		entity1 = new BasicEntity();
		entity1.setTexture(square1);
		entity1.setColor(Color.getColor(255, 255, 0));
		entity1.setMesh(mesh1);
		entity1.setPosition(new Vector3f(-.1f, -.1f, -.1f));
		getDimension().addObj(entity1, RenderClass.ENTITIES_3D);
		
		
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
	public void update() {
//		entity1.setScale(entity1.getScale() * 1.1f);
//		Vector3f rotation = new Vector3f();
//		entity1.getRotation().mul(1.4f, 1.4f, 1.4f, rotation);
//		entity1.setRotation(rotation);
//		Vector3f position = new Vector3f();
//		entity1.getPosition().mul(1.1f, 1.1f, 1.1f, position);
//		entity1.setPosition(position);
	}
	

}
