package ch.g_7.graphite.rendering.ui;

import ch.g_7.graphite.rendering.RenderClass;
import ch.g_7.graphite.ui.IUIRootContainer;

public class UIRenderClass<T extends IUIRootContainer> extends RenderClass<T, UIRenderer>{

	public UIRenderClass(String name) {
		super(new UIRenderer(), name);
	}

}
