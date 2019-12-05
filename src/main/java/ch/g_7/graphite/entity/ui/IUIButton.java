package ch.g_7.graphite.entity.ui;

import ch.g_7.graphite.entity.ui.util.UIMouseListner;

public interface IUIButton extends IUIPanel, UIMouseListner{

	void addMouseListner(UIMouseListner mouseListner);
	
	void removeMouseListner(UIMouseListner mouseListner);

	void clearMouseListners();

	boolean contains(float x, float y);
	
}
