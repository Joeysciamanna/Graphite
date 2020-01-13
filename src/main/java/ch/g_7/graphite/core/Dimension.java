package ch.g_7.graphite.core;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.IRenderer;
import ch.g_7.graphite.rendering.RenderCluster;

public final class Dimension implements AutoCloseable {

	private List<RenderCluster<?,?>> renderClusters;
	
	public Dimension() {
		renderClusters = new ArrayList<>(20);
	}
	
	public <T extends IEntity> void addObj(T renderable, RenderCluster<T,? extends IRenderer<T>> renderClass) {
		if(!renderClusters.contains(renderClass)) {
			renderClusters.add(renderClass);
			renderClass.init();
		}
		renderClass.addNode(renderable);
	}
	
	public void remove(RenderCluster<?,?> renderClass) {
		renderClusters.remove(renderClass);
		renderClass.close();
	}
	
	public List<RenderCluster<?,?>> getRenderClasses() {
		return renderClusters;
	}

	@Override
	public void close() {
		for (RenderCluster<?,?> renderCluster : renderClusters) {
			renderCluster.close();
		}
	}

	public void update(double deltaMillis) {
		for (RenderCluster<?, ?> renderCluster : renderClusters) {
			renderCluster.update(deltaMillis);
		}
	}
	
	
	
}
