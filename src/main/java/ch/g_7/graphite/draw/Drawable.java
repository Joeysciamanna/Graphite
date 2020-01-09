package ch.g_7.graphite.draw;

import ch.g_7.graphite.node.INode;

public interface Drawable extends INode {
	
	IDrawContext draw();
	
	void initDrawContext(IDrawContext context);

}
