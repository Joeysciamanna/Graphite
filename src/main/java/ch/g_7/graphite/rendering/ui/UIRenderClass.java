package ch.g_7.graphite.rendering.ui;

import ch.g_7.graphite.rendering.RenderClass;
import ch.g_7.graphite.ui.IUIRootContainer;

public class UIRenderClass extends RenderClass<IUIRootContainer, UIRenderer>{

	public UIRenderClass() {
		super(new UIRenderer(), "UI");
	}

}
