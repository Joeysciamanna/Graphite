package ch.g_7.graphite.rendering.renderer;

import java.util.List;

import ch.g_7.graphite.core.Window;
import ch.g_7.graphite.ingame.entity.Camera;
import ch.g_7.graphite.rendering.Dimension;
import ch.g_7.graphite.rendering.Renderable;
import ch.g_7.util.stuff.Initializable;

public interface IRenderer<T extends Renderable> extends Initializable, AutoCloseable {
	
	void render(List<T> renderables, Dimension dimension, Window window, Camera camera);

	@Override
	void close();
}
