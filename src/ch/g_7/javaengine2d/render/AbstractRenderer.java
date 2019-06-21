package ch.g_7.javaengine2d.render;

import ch.g_7.javaengine2d.base.object.Camera;
import ch.g_7.javaengine2d.core.Dimension;
import ch.g_7.javaengine2d.core.Window;

public abstract class AbstractRenderer {
	
	public abstract void init();

	public abstract void render(Window window, Camera camera, Dimension dimension);
	
	public abstract void close();
}
