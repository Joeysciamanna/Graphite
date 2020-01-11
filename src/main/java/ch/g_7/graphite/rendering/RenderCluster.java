package ch.g_7.graphite.rendering;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.Cluster;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.util.ResourceHandler;
import ch.g_7.util.able.Initializable;

public class RenderCluster<T extends INode, R extends IRenderer<T>> extends Cluster<T> implements AutoCloseable, Initializable{
	
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
	
	@Override
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}
	
	protected void doInit() {
		renderer.init();
		foreach((n)->n.init());
	}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallInitialize(this)) doClose();
	}

	protected void doClose() {
		renderer.close();
		foreach((n)->n.close());
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
