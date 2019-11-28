//package ch.g_7.graphite.entity.ui.util;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import ch.g_7.graphite.entity.ui.IUIPanel;
//
//public class ForgroundManager {
//
//	private List<IUIPanel> panels;
//	
//	public ForgroundManager() {
//		this.panels = new ArrayList<>();
//	}
//	
//
//	
//	public void stepForground(IUIPanel panel) {
//		
//	}
//	
//	public void inForground(IUIPanel panel) {
//		
//	}
//	
//	public void stepBackground(IUIPanel panel) {
//		
//	}
//	
//	public void inBackground(IUIPanel panel) {
//		
//	}
//	
//	public double getLevel(IUIPanel panel) {
//		return (1 / panels.size()) * panels.indexOf(panel);
//	}
//	
//	public void add(IUIPanel panel, int level) {
//		panels.add(level,panel);
//		panel.setLevel(panels.indexOf(panel));
//	}
//}
