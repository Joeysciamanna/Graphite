package ch.g_7.graphite.rendering;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.resource.Resource;

public abstract class RenderCluster<T extends INode, R extends IRenderer<T>> extends Resource implements AutoCloseable, Initializable, Updatable{
	
	private static final List<String> RENDER_CLUSTERS = new ArrayList<String>();
	
	protected final List<T> nodes;
	private final R renderer;
	private final String name;
	
	public RenderCluster(R renderer, String name){
		if(RENDER_CLUSTERS.contains(name)) {
			throw new IllegalStateException("Cant create multiple time th same RenderCluster");
		}
		RENDER_CLUSTERS.add(name);
		
		this.renderer = renderer;
		this.name  = name;
		this.nodes = new ArrayList<T>();
	}
	
	public void render(Window window, Camera camera) {
		renderer.render(nodes, window, camera);
	}

	@Override
	public void update(float deltaMillis) {}
	
	public void foreach(Consumer<T> consumer) {
		for (T node : nodes) {
			consumer.accept(node);
		}
	}
	
	public void addNode(T node) {
		nodes.add(node);
		node.init();
	}
	
	public void removeNode(IEntity node) {
		node.close();
		nodes.remove(node);
	}
	
	@Override
	protected void doInit() {
		renderer.init();
		foreach((n)->n.init());
	}
	
	@Override
	protected void doClose() {
		renderer.close();
		foreach((n)->n.close());
	}

	@Override
	public final boolean equals(Object obj) {
		return obj instanceof RenderCluster ? name.equals(name) : false;
	}
	
	public R getRenderer() {
		return renderer;
	}
	
}
