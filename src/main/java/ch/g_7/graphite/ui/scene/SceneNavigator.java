package ch.g_7.graphite.ui.scene;//package ch.g_7.graphite.ui.scene;

import ch.g_7.graphite.core.World;

import java.util.HashMap;
import java.util.Map;

public class SceneNavigator {

	private World world;
	private Map<ISceneIdentifier<?>, Scene> scenes;
	private Scene activeScene;


	public SceneNavigator(World world) {
		this.world = world;
		this.scenes = new HashMap<>();
	}


	public void goTo(ISceneIdentifier<?> key) {
		if(activeScene != null) {
			activeScene.onClose();
			activeScene.setVisible(false);
		}
		this.activeScene = scenes.get(key);
		activeScene.setVisible(true);
		activeScene.onOpen();
	}

	public void close() {
		activeScene.onClose();
		activeScene.setVisible(false);
	}

	public void registerScene(ISceneIdentifier<?> key, Scene scene) {
		scene.setVisible(false);
		scenes.put(key, scene);
		world.addEntity(scene);
	}
}
