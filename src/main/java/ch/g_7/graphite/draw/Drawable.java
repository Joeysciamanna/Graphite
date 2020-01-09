package ch.g_7.graphite.draw;

import ch.g_7.graphite.node.INode;

public interface Drawable extends INode {
	
	DrawContext draw();
	
	void initDrawContext(DrawContext context);

}
