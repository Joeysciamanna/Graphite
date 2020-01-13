package ch.g_7.graphite.draw;

import ch.g_7.graphite.entity.Updatable;

public interface Drawable extends Updatable {
	
	DrawContext draw();
	
	void initDrawContext(DrawContext context);

}
