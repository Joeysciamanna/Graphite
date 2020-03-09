package ch.g_7.graphite.rendering;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.helper.Util;

import java.util.ArrayList;
import java.util.List;

public abstract class RenderClass<T extends INode<? extends INode<?>>, R extends IRenderer<? super T>> implements Closeable, Initializable, Updatable {

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
	}
	
	public void removeNode(T node) {
		node.close();
		nodes.remove(node);
	}

	public void removeAllNodes(){
		new ArrayList<>(nodes).forEach(this::removeNode);
	}

	@Override
	public void init() {
		renderer.init();
	}
	
	@Override
	public void close() {
		renderer.close();
		nodes.forEach(Closeable::close);
	}

	@Override
	public final boolean equals(Object obj) {
		return Util.isEqual(this, obj, RenderClass::getName);
	}
	
	public String getName() {
		return name;
	}
	
	public R getRenderer() {
		return renderer;
	}
	
}
