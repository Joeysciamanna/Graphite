package ch.g_7.graphite.render;

import ch.g_7.graphite.base.object.Camera;
import ch.g_7.graphite.core.Dimension;
import ch.g_7.graphite.core.Initializable;
import ch.g_7.graphite.core.Window;

public abstract class AbstractRenderer implements Initializable{

	public abstract void render(Window window, Camera camera, Dimension dimension);
	
	public abstract void close();
}
