package ch.g_7.graphite.ui.util;//package ch.g_7.graphite.ui.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.lwjgl.glfw.GLFW;

import ch.g_7.graphite.core.window.MouseEvent;
import ch.g_7.graphite.core.window.MouseListner;
import ch.g_7.graphite.ui.IUIButton;

public class  MouseManager implements MouseListner {

	private List<IUIButton> buttons;
	private List<IUIButton> clickeds;

	public MouseManager() {
		this.buttons = new ArrayList<>();
		this.clickeds = new ArrayList<>();
	}

	@Override
	public void onAction(MouseEvent e) {
		CompletableFuture.runAsync(() -> {

			UIMouseEvent event = new UIMouseEvent(e.getButton(), e.getMods(), e.getX(), e.getY());
			List<IUIButton> inRange = new ArrayList<>();

			event.setFromLocalSource(true);
			for (IUIButton button : buttons) {
				if (button.isVisible() && button.getRootContainer().isVisible() && button.contains(event.getX(), event.getY())) {
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
					if (button.isVisible() && button.getRootContainer().isVisible() && !inRange.contains(button)) {
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
