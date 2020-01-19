package ch.g_7.graphite.ui.scene;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.UIRootContainer;

public class Scene extends UIRootContainer {

	protected static final SceneNavigator navigator = SceneNavigator.getInstance();
	protected final String name;
	
	public Scene(String name, Window window) {
		super(window);
		this.name = name;
		navigator.addScene(name, this);
	}

	protected void onOpen() {}
	protected void onClose() {}
	
	protected final void activate() {
		navigator.goTo(name);
	}
	
	protected final void deaktivate() {
		navigator.close(this);
	}
}
