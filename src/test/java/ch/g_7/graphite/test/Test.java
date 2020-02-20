package ch.g_7.graphite.test;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.MeshKey;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.SpriteKey;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.graphite.rendering.transformator.OrthographicTransformator;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.helper.AppInitializer;

public class Test extends Application {

	private static Test test;

	private List<Entity> entities = new ArrayList<>();

	public Test() {
		super("Test");
	}
	
	public static void main(String[] args) {
		test = new Test();
		test.start();
	}
	
	private ViewModel viewModel1;
	
	@Override
	public void init() {
		AppInitializer appInitializer = new AppInitializer(true, "Test", new Object() {});
		appInitializer.addConsoleLoggers();

		float[] positions = new float[]{
				-0.5f, -0.5f, 0.0f,
				0.5f, -0.5f, 0.0f,
				0.5f,  0.5f, 0.0f,
				-0.5f,  0.5f, 0.0f,
		};
		int[] indices = new int[]{
				0, 1, 3, 3, 1, 2,
		};


		Image image = ResourceManager.getActive().getResource(new SpriteKey("textures/square3.png", 16, 0, 16, 16));
		//Mesh mesh = ResourceManager.getActive().getResource(MeshFactory2d.getSquare(1).setCenter(MeshKeyBuilder2d.CENTER_MIDDLE).build());
		Mesh mesh = ResourceManager.getActive().getResource(new MeshKey(positions, indices));

		viewModel1 = new ViewModel(mesh, image, Color.TRANSPARENT);
		Entity entity = new Entity(viewModel1);
		entity.getTransformation().setPosition(new Vector3f( 0,0, 0));
		entity.getTransformation().setScale(new Vector3f(1,1,1));
		getDimension().addObj(entity, RenderType.ENTITIES);


		getDimension().getRenderClass(RenderType.ENTITIES).getRenderer().setTransformator(new OrthographicTransformator());


		getWindow().setVisible(true);
		getWindow().setSize(500, 500);

	}






	@Override
	@SuppressWarnings("deprecation")
	public void update(float deltaMillis) {
		if(getWindow().isKeyPressed(GLFW.GLFW_KEY_R)) {
			System.out.println("Used resources:      " + ResourceManager.getTotalRequests());
			System.out.println("Allocated resources: " + ResourceManager.getTotalAllocations());
		}
		if(getWindow().isKeyPressed(GLFW.GLFW_KEY_F)) {
			System.out.println("FPS:      " + getTimer().getLPS());
			System.out.println("Delta:    " + deltaMillis);
			System.out.println("FPS Calc: " + 1000/deltaMillis);
		}
		for (Entity entity : entities) {
			entity.getTransformation().getRotation().add(0,0,0.1f);
		}
	}
	
	@Override
	public void close() {
		viewModel1.close();
		ResourceManager.closeAll();
		super.close();
	}
}
