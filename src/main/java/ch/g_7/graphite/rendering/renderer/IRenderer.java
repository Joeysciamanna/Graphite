package ch.g_7.graphite.rendering.renderer;

import java.util.List;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.Dimension;
import ch.g_7.graphite.rendering.Renderable;
import ch.g_7.util.stuff.Initializable;

public interface IRenderer<R extends Renderable> extends Initializable, AutoCloseable {
	
	void render(List<R> renderClass, Dimension dimension, Window window, Camera camera);

	@Override
	void close();
}
