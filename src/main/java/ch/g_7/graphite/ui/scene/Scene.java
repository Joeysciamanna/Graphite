package ch.g_7.graphite.ui.scene;//package ch.g_7.graphite.ui.scene;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.core.window.KeyListner;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.UIRootContainer;
import ch.g_7.graphite.ui.util.IUIViewIdentifier;

public class Scene extends UIRootContainer {

	protected final SceneNavigator navigator;
	private List<KeyListner> keyListners;


	public Scene(SceneNavigator navigator, Window window, IUIViewIdentifier<?> id) {
		super(window, id);
		this.navigator = navigator;
		this.keyListners = new ArrayList<>();
	}


	public void addKeyListner(KeyListner keyListner) {
		keyListners.add(keyListner);
	}

	public void removeKeyListner(KeyListner keyListner) {
		keyListners.remove(keyListner);
	}

	protected void onOpen() {
		for (KeyListner keyListner : keyListners) {
			getWindow().addKeyListner(keyListner);
		}

	}

	protected void onClose() {
		for (KeyListner keyListner : keyListners) {
			getWindow().removeKeyListner(keyListner);
		}
	}


}
