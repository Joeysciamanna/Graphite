package ch.g_7.graphite.ui.scene;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.UIRootContainer;

public class Scene extends UIRootContainer {

	protected SceneNavigator navigator;
	
	public Scene(SceneNavigator navigator, Window window) {
		super(window);
		this.navigator = navigator;
	}

	protected void onOpen() {}
	protected void onClose() {}
}
