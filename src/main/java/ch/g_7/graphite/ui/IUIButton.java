package ch.g_7.graphite.ui;

import ch.g_7.graphite.ui.util.UIMouseListner;

public interface IUIButton extends IUIPanel, UIMouseListner{

	void addMouseListner(UIMouseListner mouseListner);

	void removeMouseListner(UIMouseListner mouseListner);

	void clearMouseListners();

	boolean contains(float x, float y);

}
