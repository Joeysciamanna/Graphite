package ch.g_7.graphite.entity.ui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.lwjgl.glfw.GLFW;

import ch.g_7.graphite.core.window.MouseEvent;
import ch.g_7.graphite.core.window.MouseListner;
import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.util.task.Task;

public class MouseManager implements MouseListner{

	private HashMap<IUIPanel, List<UIMouseListner>> listners;
	
	private HashMap<IUIPanel, List<UIMouseListner>> clickeds;
	
	
	public MouseManager() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onMouseClick(MouseEvent e) {
		
		if(e.getAction() == GLFW.GLFW_RELEASE) {
			for (Entry<IUIPanel, List<UIMouseListner>> clicked : clickeds.entrySet()) {
				
			}
		}
		
		
		for (Entry<IUIPanel, List<UIMouseListner>> entry : listners.entrySet()) {
			if(entry.getKey().getPixelBounds().contains(e.getX(), e.getY())){
				for (UIMouseListner listner : entry.getValue()) {
					UIMouseEvent event = new UIMouseEvent(e, entry.getKey());
					if(e.getAction() == GLFW.GLFW_PRESS) {
						listner.onClick(event);
						clickeds.add(event);
					}else {
						listner.onRelease(event);
					}
				}
			}
		}
		
	}

	
	public void addClickListner(IUIPanel panel, UIMouseListner listner) {
		if(listners.containsKey(panel)) {
			listners.get(panel).add(listner);
		}else {
			List<UIMouseListner> list = new ArrayList<UIMouseListner>();
			list.add(listner);
			listners.put(panel, list);
		}
	}
	
}
