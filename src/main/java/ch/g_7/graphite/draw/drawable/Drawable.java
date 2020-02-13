package ch.g_7.graphite.draw.drawable;

import ch.g_7.graphite.draw.DrawContext2d;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Updatable;

public interface Drawable extends INode, Updatable {
	
	DrawContext2d draw();
	
	void initDrawContext(DrawContext2d context);

}
