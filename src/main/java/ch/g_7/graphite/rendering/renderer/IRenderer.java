package ch.g_7.graphite.rendering.renderer;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.Dimension;
import ch.g_7.graphite.rendering.RenderClass;
import ch.g_7.graphite.rendering.Renderable;
import ch.g_7.util.stuff.Initializable;

public interface IRenderer<T extends Renderable> extends Initializable, AutoCloseable {
	
	void render(RenderClass<T> renderClass, Dimension dimension, Window window, Camera camera);

	@Override
	void close();
}
