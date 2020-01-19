package ch.g_7.graphite.ui.scene;

import java.util.HashMap;
import java.util.Map;

import ch.g_7.graphite.core.Dimension;
import ch.g_7.graphite.core.RenderClasses;

public class SceneNavigator {

	private Dimension dimension;
	private Map<String, Scene> scenes;
	private Scene activeScene;


	public SceneNavigator(Dimension dimension) {
		this.dimension = dimension;
		this.scenes = new HashMap<String, Scene>();
	}
	
	
	public void goTo(String key) {
		if(activeScene != null) {
			activeScene.onClose();
			activeScene.setVisible(false);
		}
		this.activeScene = scenes.get(key);
		activeScene.setVisible(true);
		activeScene.onOpen();
	}
	
	public void close(String key) {
		Scene scene = scenes.get(key);
		scene.onClose();
		scene.setVisible(false);
	}
	
	public void addScene(String key, Scene scene) {
		scenes.put(key, scene);
		dimension.addObj(scene, RenderClasses.UI);
	}
}
