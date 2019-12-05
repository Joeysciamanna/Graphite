package ch.g_7.graphite.entity.ui.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.lwjgl.glfw.GLFW;

import ch.g_7.graphite.core.window.MouseEvent;
import ch.g_7.graphite.core.window.MouseListner;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.ui.IUIButton;

public class MouseManager implements MouseListner {

	private List<IUIButton> buttons;
	private List<IUIButton> clickeds;
	private Window window;

	public MouseManager(Window window) {
		this.buttons = new ArrayList<>();
		this.clickeds = new ArrayList<>();
		this.window  = window;
	}

	@Override
	public void onMouseClick(MouseEvent e) {
		CompletableFuture.runAsync(() -> {

			UIMouseEvent event = new UIMouseEvent(e.getButton(), e.getMods(), e.getX() * 2f / window.getWidth(), e.getY() * 2f / window.getHeight());
			List<IUIButton> inRange = new ArrayList<>();
			
			event.setFromLocalSource(true);
			for (IUIButton button : buttons) {
				if (button.contains(event.getX(), event.getY())) {
					event.setButtonPanel(button);
					if (e.getAction() == GLFW.GLFW_PRESS) {
						
	
						
						button.onClick(event);
						clickeds.add(button);
					} else {
						button.onRelease(event);
						inRange.add(button);
					}
				}
			}

			event.setFromLocalSource(false);
			if (e.getAction() == GLFW.GLFW_RELEASE) {
				for (IUIButton button : clickeds) {
					if (!inRange.contains(button)) {
						event.setButtonPanel(button);
						button.onRelease(event);
					}
				}
				clickeds.clear();
			}
		});
	}

	public void addClickListner(IUIButton button) {
		buttons.add(button);
	}

	public void remove(IUIButton button) {
		buttons.remove(button);
	}
}
