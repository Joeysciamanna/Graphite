package ch.g_7.graphite.rendering.renderclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.g_7.graphite.base.object.Camera;
import ch.g_7.graphite.core.Window;
import ch.g_7.graphite.rendering.Renderable;
import ch.g_7.graphite.rendering.renderer.IRenderer;

public final class RenderClass<T extends Renderable>{
	
	protected List<T> renderables;
	
	protected IRenderer<T> renderer;
	
	protected String name;
	
	private RenderClass(IRenderer<T> renderer, String name, int size) {
		this.renderables = new ArrayList<>(size);
		this.renderer = renderer;
		this.name = name;
	}
	
	public void add(T renderalbe) {
		renderables.add(renderalbe);
	}
	
	public List<T> getAll(){
		return renderables;
	}
	

	public boolean equals(RenderClass<?> renderClass) {
		return name.equals(renderClass.name);
	}
	
	private static final Map<String, RenderClass<?>> RENDER_CLASSES = new HashMap<>();
	@SuppressWarnings("unchecked")
	public static <T extends Renderable>  RenderClass<T> create(IRenderer<T> renderer, String name, int size) {
		if(RENDER_CLASSES.containsKey(name)) {
			return (RenderClass<T>) RENDER_CLASSES.get(name);
		}
		RenderClass<T> renderClass = new RenderClass<>(renderer, name, size);
		RENDER_CLASSES.put(name, renderClass);
		return renderClass;
	}
	
	public static <T extends Renderable> RenderClass<T> create(IRenderer<T> renderer, String name) {
		return create(renderer, name, 20);
	}
	
	public void render(Window window, Camera camera) {
		renderer.render(renderables, window, camera);
	}

	
}
