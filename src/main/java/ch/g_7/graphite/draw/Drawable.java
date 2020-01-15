package ch.g_7.graphite.draw;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Updatable;

public interface Drawable extends INode, Updatable {
	
	DrawContext draw();
	
	void initDrawContext(DrawContext context);

}
