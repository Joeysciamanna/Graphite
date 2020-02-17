package ch.g_7.graphite.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.mesh.MeshKeyBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.TextureUtil;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.graphite.rendering.transformator.OrthographicTransformator;
import ch.g_7.util.helper.AppInitializer;
import ch.g_7.util.resource.ResourceManager;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

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
	
	@Override
	public void init() {
		AppInitializer appInitializer = new AppInitializer(true, "Test", new Object() {});
		appInitializer.addConsoleLoggers();


		float maxX = 32;
		float tileSize = 2f/32;

		Image image = null;
		try {
			image = TextureUtil.loadImage("C:\\-\\workspace\\java\\graphite\\src\\test\\resources\\textures\\square3.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ViewModel viewModel1 = new ViewModel();
		viewModel1.setMesh(MeshFactory2d.getSquare(tileSize).setCenter(MeshKeyBuilder2d.CENTER_MIDDLE).build());
		viewModel1.setTexture(image);


		for (float i = 0; i < 100000; i++) {
			Entity entity = new Entity();
			entity.getTransformation().setPosition(new Vector3f( (i % maxX) * 2 / (100000/32) - 1,(i / maxX) * 2 / (100000/32) - 1, 0));
			entity.setViewModel(viewModel1);
			getDimension().addObj(entity, RenderType.ENTITIES);
			entities.add(entity);
		}

		getDimension().getRenderClass(RenderType.ENTITIES).getRenderer().setTransformator(new OrthographicTransformator());


		getWindow().setVisible(true);
		getWindow().setSize(500, 500);

	}

	@Override
	@SuppressWarnings("deprecation")
	public void update(float deltaMillis) {
		if(getWindow().isKeyPressed(GLFW.GLFW_KEY_R)) {
			System.out.println("Used resources:      " + ResourceManager.getInstance().getCurrentResourceCount());
			System.out.println("Allocated resources: " + ResourceManager.getInstance().getCurrentResourceAllocations());
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
}
