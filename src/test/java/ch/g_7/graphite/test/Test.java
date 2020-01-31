package ch.g_7.graphite.test;

import java.nio.file.Path;
import java.nio.file.Paths;

import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.TextureUtil;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.graphite.rendering.transformator.OrthographicTransformator;
import ch.g_7.util.helper.AppInitializer;
import ch.g_7.util.task.SecureRunner;

public class Test extends Application {

	private static Test test;
	
	public Test() {
		super("Test");
	}
	
	public static void main(String[] args) {
		test = new Test();
		test.start();
	}
	
	@Override
	public void init() {
		
		SecureRunner<String, Image> imageLoader = new SecureRunner<>((s)->TextureUtil.loadImage(s));

		AppInitializer appInitializer = new AppInitializer("", new Object() {});
		appInitializer.setDebugMode(true);
		appInitializer.initLogger();
		appInitializer.addConsoleLoggers();


		Path path1 = Paths.get("src/test/resources/textures/square1.png");
		Path absolutePath1 = path1.toAbsolutePath();
		Image square1 = imageLoader.apply(absolutePath1.toString());
		
		Path path2 = Paths.get("src/test/resources/textures/square2.png");
		Path absolutePath2 = path2.toAbsolutePath();
		Image square2 = imageLoader.apply(absolutePath2.toString());
		
		//Sprite sprite = TextureUtil.loadSprite(square1, 0, 0, 4, 4);


		ViewModel viewModel1 = new ViewModel();
		viewModel1.setMesh(MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_MIDDLE).build());
		viewModel1.setTexture(square1);

		ViewModel viewModel2 = viewModel1.clone();
		viewModel2.setTexture(square2);
		
		Entity entity1 = new Entity();
		entity1.setViewModel(viewModel1);
		entity1.getTransformation().getPosition().x+=1;
		
		Entity entity2 = new Entity();
		entity2.setViewModel(viewModel2);
		entity2.getTransformation().getPosition().x-=1;
		
		getDimension().addObj(entity1, RenderType.ENTITIES);
		getDimension().addObj(entity2, RenderType.ENTITIES);

		getDimension().getRenderClass(RenderType.ENTITIES).getRenderer().setTransformator(new OrthographicTransformator());
		
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
}
