package ch.g_7.graphite.ui.scene;

import java.util.HashMap;
import java.util.Map;

import ch.g_7.graphite.core.RenderClasses;
import ch.g_7.graphite.rendering.ui.UIRenderClass;

public class SceneNavigator {
	
	private UIRenderClass renderClass = RenderClasses.UI;
	private Map<String, Scene> scenes;
	private Scene activeScene;

	private final static SceneNavigator instance = new SceneNavigator();
	
	private SceneNavigator() {
		this.scenes = new HashMap<String, Scene>();
	}
	
	public static SceneNavigator getInstance() {
		return instance;
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
		renderClass.removeNode(scene);
		this.activeScene = null;
	}
	
	public void open(Scene scene) {
		scene.setVisible(true);
		renderClass.addNode(scene);
		scene.onOpen();
		this.activeScene = scene;
	}
	
	public void addScene(String key, Scene scene) {
		scenes.put(key, scene);
	}
}
