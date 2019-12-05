package ch.g_7.graphite.entity.ui;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.entity.ui.util.UIMouseEvent;
import ch.g_7.graphite.entity.ui.util.UIMouseListner;

public class UIButton extends UIPanel implements IUIButton{

	private List<UIMouseListner> mouseListners;
	
	
	public UIButton() {
		this.mouseListners = new ArrayList<UIMouseListner>();
	}
	
	private Rectangle getPixelBounds() {
		return new Rectangle((int) (position.x * getWindow().getWidth() / 2f),
							 (int) (position.y * getWindow().getHeight() / 2f), 
							 (int) (size.x * getWindow().getWidth() / 2f),
							 (int) (size.y * getWindow().getHeight() / 2f));
	}


	@Override
	public boolean contains(int x, int y) {
		return getPixelBounds().contains(x, y);
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
