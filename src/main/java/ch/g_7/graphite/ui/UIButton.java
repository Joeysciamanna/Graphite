package ch.g_7.graphite.ui;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.ui.util.UIMouseEvent;
import ch.g_7.graphite.ui.util.UIMouseListner;

public class UIButton extends UIPanel implements IUIButton{

	private List<UIMouseListner> mouseListners;
	
	
	public UIButton() {
		this.mouseListners = new ArrayList<UIMouseListner>();
	}

	@Override
	public boolean contains(float x, float y) {
		return getPosition().x() < x && 
			   getPosition().y() < y &&
			   getSize().x() + getPosition().x() > x &&
			   getSize().y() + getPosition().y() > y;
	}
	
	@Override
	protected void doInit() {
		super.doInit();
		getRootContainer().getMouseManager().addClickListner(this);
		addMouseListner(new UIMouseListner(){
			private boolean clicked;
			@Override
			public void onClick(UIMouseEvent e) {
				if (!clicked) e.getButtonPanel().getViewModel().getColor().darker(20);
				clicked = true;
			}
			@Override
			public void onRelease(UIMouseEvent e) {
				if (clicked) e.getButtonPanel().getViewModel().getColor().lighter(20);
				clicked = false;
			}
		});
	}

	@Override
	public void onClick(UIMouseEvent event) {
		mouseListners.forEach((l)->l.onClick(event));
	}

	@Override
	public void onRelease(UIMouseEvent event) {
		mouseListners.forEach((l)->l.onRelease(event));
	}

	@Override
	public void addMouseListner(UIMouseListner mouseListner) {
		mouseListners.add(mouseListner);
	}

	@Override
	public void removeMouseListner(UIMouseListner mouseListner) {
		mouseListners.remove(mouseListner);
	}

	@Override
	public void clearMouseListners() {
		mouseListners.clear();
	}


}
