package ch.g_7.graphite.ui.scene;

import java.util.HashMap;
import java.util.Map;

import ch.g_7.graphite.core.Dimension;
import ch.g_7.graphite.rendering.RenderType;

public class SceneNavigator {

	private Dimension dimension;
	private Map<ISceneIdentifier<?>, Scene> scenes;
	private Scene activeScene;


	public SceneNavigator(Dimension dimension) {
		this.dimension = dimension;
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
	
	public void close(ISceneIdentifier<?> key) {
		Scene scene = scenes.get(key);
		scene.onClose();
		scene.setVisible(false);
	}
	
	public void registerScene(ISceneIdentifier<?> key, Scene scene) {
		scene.setVisible(false);
		scenes.put(key, scene);
		dimension.addObj(scene, RenderType.UI);
	}
}
