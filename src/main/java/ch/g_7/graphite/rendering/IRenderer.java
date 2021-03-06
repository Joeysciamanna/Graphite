package ch.g_7.graphite.rendering;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.Renderable;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

public interface IRenderer<T extends INode<?, ?>> extends Initializable, Closeable, IRenderResource {

	void render(Window window, Camera camera);

	IRenderType<?> getRenderType();

	void addRenderable(T renderable);

	void removeRenderable(T renderable);

	void clear();

	boolean isUsed();

}
