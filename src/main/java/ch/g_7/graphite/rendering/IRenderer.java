package ch.g_7.graphite.rendering;

import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.IRenderResource;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

public interface IRenderer<R extends IViewModel> extends Initializable, Closeable, IRenderResource {

	IRenderType<?> getRenderType();

	void addRenderable(INode<?, R> t);

	void removeRenderable(INode<?, R> t);

	boolean isUsed();

	void render(Window window, Camera camera);

}
