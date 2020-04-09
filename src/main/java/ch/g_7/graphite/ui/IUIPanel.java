package ch.g_7.graphite.ui;//package ch.g_7.graphite.ui;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.node.Renderable;
import ch.g_7.graphite.ui.util.IScreenDimension;
import ch.g_7.graphite.ui.util.ScreenDimension;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.common.Initializable;

public interface IUIPanel extends IUIContainer {

	void setFather(IUIContainer container);

	IUIContainer getFather();

	void setColor(Color color);

	void setTexture(ITexture texture);

	ScreenDimension getWidth();
	ScreenDimension getHeight();

	ScreenDimension getMinWidth();
	ScreenDimension getMinHeight();

	ScreenDimension getMaxWidth();
	ScreenDimension getMaxHeight();

	ScreenDimension getX();
	ScreenDimension getY();
}
