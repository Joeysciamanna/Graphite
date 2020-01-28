package ch.g_7.graphite.test;

import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.Sprite;
import ch.g_7.graphite.base.texture.TextureUtil;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.core.RenderClasses;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.rendering.transformator.OrthographicTransformator;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.helper.AppInitializer;
import ch.g_7.util.stuff.SecureRunner;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Test extends Application {

	private static Test test;

	private Entity entity1;
	
	public Test() {
		super("Test");
	}
	
	public static void main(String[] args) {
		test = new Test();
		test.start();
	}
	
	@Override
	public void init() {
		RenderClasses.ENTITIES.getRenderer().setTransformator(new OrthographicTransformator());

		AppInitializer appInitializer = new AppInitializer("", new Object() {});
		appInitializer.setDebugMode(true);
		appInitializer.initLogger();
		appInitializer.addConsoleLogWriters();


		Path path = Paths.get("src/test/resources/textures/square1.png");
		Path absolutePath = path.toAbsolutePath();
		Image square1 = new SecureRunner<Void, Image>(() -> TextureUtil.loadImage(absolutePath.toString())).run();
		Sprite sprite = TextureUtil.loadSprite(square1, 0, 0, 8, 8);


		ViewModel viewModel = new ViewModel();
		viewModel.setMesh(MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_MIDDLE).build());
		viewModel.setTexture(sprite);

		entity1 = new Entity();
		entity1.setViewModel(viewModel);
		getDimension().addObj(entity1, RenderClasses.ENTITIES);

		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
}
