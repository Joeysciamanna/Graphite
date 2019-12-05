package ch.g_7.graphite.entity.ui;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.entity.ui.util.UIMouseEvent;
import ch.g_7.graphite.entity.ui.util.UIMouseListner;

public class UIButton extends UIPanel implements IUIButton{

	private List<UIMouseListner> mouseListners;
	
	
	public UIButton() {
		this.mouseListners = new ArrayList<UIMouseListner>();
	}

	@Override
	public boolean contains(float x, float y) {
		return position.x < x && 
			   position.y < y &&
			   size.x + position.x > x &&
			   size.y + position.y > y;
	}
	
	@Override
	public void init() {
		super.init();
		getRootContainer().getMouseManager().addClickListner(this);
		addMouseListner(new UIMouseListner(){
			private boolean clicked;
			@Override
			public void onClick(UIMouseEvent e) {
				clicked = true;
				e.getButtonPanel().getColor().darker(10);
			}
			@Override
			public void onRelease(UIMouseEvent e) {
				if (clicked) e.getButtonPanel().getColor().lighter(10);
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
