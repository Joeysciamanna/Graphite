package ch.g_7.graphite.ui.scene;

import java.util.HashMap;
import java.util.Map;

import ch.g_7.graphite.rendering.ui.UIRenderCluster;

public class SceneNavigator {
	
	private UIRenderCluster renderCluster;
	private Map<String, Scene> scenes;
	private Scene activeScene;

	public SceneNavigator(UIRenderCluster renderCluster) {
		this.scenes = new HashMap<String, Scene>();
		this.renderCluster = renderCluster;
	}
	
	public void goTo(String key) {
		if(activeScene != null) {
			close(activeScene);
		}
		open(scenes.get(key));
	}
	
	public void close(Scene scene) {
		scene.onClose();
		scene.setVisible(false);
		renderCluster.removeNode(scene);
		this.activeScene = null;
	}
	
	public void open(Scene scene) {
		scene.setVisible(true);
		renderCluster.addNode(scene);
		scene.onOpen();
		this.activeScene = scene;
	}
	
	public void addScene(String key, Scene scene) {
		scenes.put(key, scene);
	}
}
