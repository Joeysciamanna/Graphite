package ch.g_7.graphite.rendering;

import java.util.List;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.IEntity;
import ch.g_7.util.able.Initializable;

public interface IRenderer<T> extends Initializable, AutoCloseable {
	
	void render(List<T> nodes, Window window, Camera camera);

	@Override
	void close();
}
