package ch.g_7.graphite.core;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.rendering.IRenderer;
import ch.g_7.graphite.rendering.RenderClass;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.GenericProducerType;
import ch.g_7.util.resource.IDepender;

public final class Dimension implements Closeable, Updatable, IDepender {

	private List<RenderClass<?,?>> renderClasses;
	
	public Dimension() {
		renderClasses = new ArrayList<>(20);
	}
	
	public <T extends INode> void addObj(T renderable, GenericProducerType<? extends RenderClass<T, ? extends IRenderer<T>>> renderType) {
		for (RenderClass<?, ?> renderClass : renderClasses) {
			if(renderType.typeEquals(renderClass.getClass())) {
				renderType.cast(renderClass).addNode(renderable);
				return;
			}
		}
		RenderClass<T, ? extends IRenderer<T>> renderClass = renderType.get();
		renderClass.bind(this);
		renderClasses.add(renderClass);
		renderClass.addNode(renderable);
	}
	
	public <T extends RenderClass<?,?>> void remove(GenericProducerType<T> renderType) {
		RenderClass<?,?> renderClass = getRenderClass(renderType);
		renderClasses.remove(renderClass);
		renderClass.unbind(this);
	}
	
	public <T extends RenderClass<?,?>> T getRenderClass(GenericProducerType<T> renderType) {
		for (RenderClass<?, ?> renderClass : renderClasses) {
			if(renderType.typeEquals(renderClass.getClass())) {
				return renderType.cast(renderClass);
			}
		}
		throw new IllegalArgumentException("Render Class not found");
	}
	
	public List<RenderClass<?,?>> getRenderClasses() {
		return renderClasses;
	}
	
	@Override
	public void update(float deltaMillis) {
		renderClasses.forEach((r)->r.update(deltaMillis));
	}

	@Override
	public void close() {
		for (RenderClass<?,?> renderCluster : renderClasses) {
			renderCluster.unbind(this);
		}
	}

	
}
