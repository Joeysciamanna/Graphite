package ch.g_7.graphite.core;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.RenderCluster;
import ch.g_7.graphite.rendering.IRenderer;

public final class Dimension implements AutoCloseable {

	private List<RenderCluster<?,?>> renderClasses;
	
	public Dimension() {
		renderClasses = new ArrayList<>(20);
	}
	
	public <T extends INode> void addObj(T renderable, RenderCluster<T,? extends IRenderer<T>> renderClass) {
		if(!renderClasses.contains(renderClass)) {
			renderClasses.add(renderClass);
			renderClass.init();
		}
		renderClass.addNode(renderable);
	}
	
	public void remove(RenderCluster<?,?> renderClass) {
		renderClasses.remove(renderClass);
		renderClass.close();
	}
	
	public List<RenderCluster<?,?>> getRenderClasses() {
		return renderClasses;
	}

	@Override
	public void close() {
		for (RenderCluster<?,?> renderClass : renderClasses) {
			renderClass.close();
		}
	}

	public void update(double deltaMillis) {
		for (RenderCluster<?, ?> renderCluster : renderClasses) {
			renderCluster.update(deltaMillis);
		}
	}
	
	
	
}
