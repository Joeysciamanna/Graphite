package ch.g_7.java2dengine.render;

import ch.g_7.java2dengine.base.object.Camera;
import ch.g_7.java2dengine.core.Dimension;
import ch.g_7.java2dengine.core.Initializable;
import ch.g_7.java2dengine.core.Window;

public abstract class AbstractRenderer implements Initializable{

	public abstract void render(Window window, Camera camera, Dimension dimension);
	
	public abstract void close();
}
