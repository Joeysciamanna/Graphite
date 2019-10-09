package ch.g_7.graphite.base.ui;

import java.util.List;

import org.joml.Vector2ic;

public class ContainerPanel extends UIPanel {

	
	protected List<UIPanel> childs;
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		super.recalculate(screenSize);
		for (UIPanel child : childs) {
			child.recalculate(screenSize);
		}
	}
	
}
