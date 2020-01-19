package ch.g_7.graphite.ui.scene;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.UIRootContainer;

public class Scene extends UIRootContainer {

	protected static final SceneNavigator navigator = SceneNavigator.getInstance();
	
	public Scene(Window window) {
		super(window);
	}

	protected void onOpen() {}
	protected void onClose() {}
}
