package ch.g_7.graphite.rendering;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.resource.Resource;

public abstract class RenderClass<T extends INode, R extends IRenderer<? super T>> extends Resource implements AutoCloseable, Initializable, Updatable {

	protected final String name;
	protected final List<T> nodes;
	protected final R renderer;

	
	public RenderClass(R renderer, String name){
		this.renderer = renderer;
		this.name  = name;
		this.nodes = new ArrayList<T>();
	}
	
	public void render(Window window, Camera camera) {
		renderer.render(nodes, window, camera);
	}

	@Override
	public void update(float deltaMillis) {}

	public void addNode(T node) {
		nodes.add(node);
		node.bind(this);
	}
	
	public void removeNode(T node) {
		node.unbind(this);
		nodes.remove(node);
	}

	public void removeAllNodes(){
		new ArrayList<>(nodes).forEach((n)->removeNode(n));
	}

	@Override
	protected void doInit() {
		renderer.bind(this);
		nodes.forEach((n)->n.bind(this));
	}
	
	@Override
	protected void doClose() {
		renderer.unbind(this);
		nodes.forEach((n)->n.unbind(this));
	}

	@Override
	public final boolean equals(Object obj) {
		return obj instanceof RenderClass ? name.equals(((RenderClass) obj).name) : false;
	}
	
	public R getRenderer() {
		return renderer;
	}
	
}
