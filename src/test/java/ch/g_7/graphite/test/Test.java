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
import ch.g_7.graphite.ui.scene.ISceneIdentifier;
import ch.g_7.graphite.ui.scene.Scene;
import ch.g_7.graphite.ui.scene.SceneNavigator;
import ch.g_7.graphite.util.Color;
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
		AppInitializer appInitializer = new AppInitializer(true, "Test", new Object() {});
		appInitializer.addConsoleLoggers();


		SceneNavigator sceneNavigator = new SceneNavigator(getDimension());
		Scene scene = new Scene(sceneNavigator, getWindow());
		sceneNavigator.registerScene(ScenType.TEST, scene);

		ViewModel viewModel1 = new ViewModel();
		viewModel1.setMesh(MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_MIDDLE).build());
		viewModel1.setColor(Color.getColor(255,0,0));

		Entity entity1 = new Entity();
		entity1.setViewModel(viewModel1);
		entity1.getTransformation().getPosition();

		getDimension().addObj(entity1, RenderType.ENTITIES);

		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}

	private static enum ScenType implements ISceneIdentifier<ScenType> {
		TEST
	}
}
