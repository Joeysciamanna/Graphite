package ch.g_7.graphite.node;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.entity.Entity;
import ch.g_7.graphite.rendering.IRenderer;
import ch.g_7.graphite.rendering.entity.EntityRenderer;
import ch.g_7.graphite.rendering.ui.UIRenderer;
import ch.g_7.graphite.ui.IUIRootContainer;
import ch.g_7.util.able.Initializable;

public final class RenderCluster<T extends INode, R extends IRenderer<T>> extends Cluster<T> implements AutoCloseable, Initializable{

	
	public static final RenderCluster<IUIRootContainer, UIRenderer> UI = new RenderCluster<>(new UIRenderer());
	public static final RenderCluster<Entity, EntityRenderer> ENTITIES = new RenderCluster<>(new EntityRenderer());
	
	
	private final R renderer;

	public RenderCluster(R renderer){
		this.renderer = renderer;
	}
	
	public void render(Window window, Camera camera) {
		renderer.render(nodes, window, camera);
	}
	
	public void update(double deltaMillis) {
		for (INode node : nodes) {
			node.update(deltaMillis);
		}
	}

	public R getRenderer() {
		return renderer;
	}

	public void close() {
		renderer.close();
		foreach((n)->n.close());
	}

	@Override
	public void init() {
		renderer.init();
		foreach((n)->n.init());
	}
}
