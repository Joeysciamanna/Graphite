package ch.g_7.graphite.rendering;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.INode;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

import java.util.List;

public interface IRenderer<T extends INode> extends Initializable, Closeable {
	
	void render(List<? extends  T> nodes, Window window, Camera camera);
	
}
