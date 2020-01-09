package ch.g_7.graphite.node;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.BasicEntity;
import ch.g_7.graphite.rendering.IRenderer;
import ch.g_7.graphite.rendering.entity.EntityRenderer;
import ch.g_7.graphite.rendering.ui.UIRenderer;
import ch.g_7.graphite.ui.IUIRootContainer;
import ch.g_7.util.able.Initializable;

public class RenderCluster<T extends INode, R extends IRenderer<T>> extends Cluster<T> implements AutoCloseable, Initializable{

	
	public static final RenderCluster<IUIRootContainer, UIRenderer> UI = new RenderCluster<>(new UIRenderer(), "UI");
	public static final RenderCluster<BasicEntity, EntityRenderer> ENTITIES = new RenderCluster<>(new EntityRenderer(), "ENTITIES");
	
	
	private final R renderer;
	private final String name;
	
	public RenderCluster(R renderer, String name){
		this.renderer = renderer;
		this.name  = name;
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
	
	@Override
	public final boolean equals(Object obj) {
		return obj instanceof RenderCluster ? obj.toString().equals(name) : false;
	}
	
	@Override
	public final String toString() {
		return name;
	}
}
