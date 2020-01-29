package ch.g_7.graphite.core;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.rendering.IRenderer;
import ch.g_7.graphite.rendering.type.IRenderType;
import ch.g_7.graphite.rendering.type.RenderClass;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.resource.IDepender;

public final class Dimension implements Closeable, Updatable, IDepender {

	private List<RenderClass<?,?>> renderClusters;
	
	public Dimension() {
		renderClusters = new ArrayList<>(20);
	}
	
	public <T extends INode> void addObj(T renderable, IRenderType<?> renderType) {
		for (RenderClass<?, ?> renderClass : renderClusters) {
			if(renderClass.ofType(renderType)) {
				renderClass.addNode(renderable);
			}
		}
		
		if(!renderClusters.contains(renderClass)) {
			
			renderClass.bind(this);
			renderClusters.add(renderClass);
		}
		renderClass.addNode(renderable);
	}
	
	public void remove(RenderClass<?,?> renderClass) {
		renderClusters.remove(renderClass);
		renderClass.unbind(this);
	}
	
	public List<RenderClass<?,?>> getRenderClasses() {
		return renderClusters;
	}
	
	@Override
	public void update(float deltaMillis) {
		renderClusters.forEach((r)->r.update(deltaMillis));
	}

	@Override
	public void close() {
		for (RenderClass<?,?> renderCluster : renderClusters) {
			renderCluster.unbind(this);
		}
	}

	
}
