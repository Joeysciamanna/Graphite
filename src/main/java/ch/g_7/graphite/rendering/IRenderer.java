package ch.g_7.graphite.rendering;

import java.util.List;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.INode;
import ch.g_7.util.common.Initializable;

public interface IRenderer<T extends INode> extends Initializable, AutoCloseable {
	
	void render(List<T> nodes, Window window, Camera camera);

	@Override
	void close();
}
