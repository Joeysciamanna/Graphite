package ch.g_7.graphite.entity.ui;

import java.awt.Rectangle;

import ch.g_7.graphite.entity.ui.util.UIMouseListner;

public interface IUIButton extends IUIPanel, UIMouseListner{

	void addMouseListner(UIMouseListner mouseListner);
	
	void removeMouseListner(UIMouseListner mouseListner);

	void clearMouseListners();

	boolean contains(int x, int y);
	
}
