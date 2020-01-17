package ch.g_7.graphite.core;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.rendering.IRenderer;
import ch.g_7.graphite.rendering.RenderCluster;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.resource.IDepender;

public final class Dimension implements Closeable, Updatable, IDepender {

	private List<RenderCluster<?,?>> renderClusters;
	
	public Dimension() {
		renderClusters = new ArrayList<>(20);
	}
	
	public <T extends INode> void addObj(T renderable, RenderCluster<T,? extends IRenderer<T>> renderClass) {
		if(!renderClusters.contains(renderClass)) {
			
			renderClass.bind(this);
			renderClusters.add(renderClass);
		}
		renderClass.addNode(renderable);
	}
	
	public void remove(RenderCluster<?,?> renderClass) {
		renderClusters.remove(renderClass);
		renderClass.unbind(this);
	}
	
	public List<RenderCluster<?,?>> getRenderClasses() {
		return renderClusters;
	}
	
	@Override
	public void update(float deltaMillis) {
		renderClusters.forEach((r)->r.update(deltaMillis));
	}

	@Override
	public void close() {
		for (RenderCluster<?,?> renderCluster : renderClusters) {
			renderCluster.unbind(this);
		}
	}

	
}
