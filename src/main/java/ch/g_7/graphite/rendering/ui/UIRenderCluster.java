package ch.g_7.graphite.rendering.ui;

import ch.g_7.graphite.rendering.RenderCluster;
import ch.g_7.graphite.ui.IUIRootContainer;

public class UIRenderCluster extends RenderCluster<IUIRootContainer, UIRenderer>{

	public UIRenderCluster() {
		super(new UIRenderer(), "UI");
	}

}
