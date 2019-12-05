package ch.g_7.graphite.entity.ui.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.joml.Vector2i;
import org.lwjgl.glfw.GLFW;

import ch.g_7.graphite.core.window.MouseEvent;
import ch.g_7.graphite.core.window.MouseListner;
import ch.g_7.graphite.entity.ui.IUIButton;

public class MouseManager implements MouseListner {

	private List<IUIButton> buttons;
	private List<IUIButton> clickeds;

	public MouseManager() {
		this.buttons = new ArrayList<>();
		this.clickeds = new ArrayList<>();
	}

	@Override
	public void onMouseClick(MouseEvent e) {
		CompletableFuture.runAsync(() -> {

			List<IUIButton> inRange = new ArrayList<>();
			
			for (IUIButton button : buttons) {

				
				if (button.contains(e.getX(), e.getY())) {
					UIMouseEvent event = new UIMouseEvent(e, button, true);
					if (e.getAction() == GLFW.GLFW_PRESS) {
						System.out.println("CLICK 1");
						button.onClick(event);
						
						clickeds.add(button);
					} else {
						button.onRelease(event);
						inRange.add(button);
					}
				}
			}

			if (e.getAction() == GLFW.GLFW_RELEASE) {
				for (IUIButton button : clickeds) {
					if (!inRange.contains(button)) {
						UIMouseEvent event = new UIMouseEvent(e, button, false);
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
