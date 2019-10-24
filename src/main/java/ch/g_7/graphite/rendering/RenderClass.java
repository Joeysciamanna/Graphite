package ch.g_7.graphite.rendering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.object.IObject;
import ch.g_7.graphite.entity.ui.IUIRootContainer;
import ch.g_7.graphite.rendering.renderer.BasicRenderer;
import ch.g_7.graphite.rendering.renderer.IRenderer;
import ch.g_7.graphite.rendering.renderer.UIRenderer;
import ch.g_7.util.stuff.Initializable;

public final class RenderClass<T extends Renderable> implements Initializable, AutoCloseable{
	
	private static final Map<String, RenderClass<?>> RENDER_CLASSES = new HashMap<>();
	
	public static final RenderClass<IObject> BASIC_GAME_OBJECTS;
	public static final RenderClass<IUIRootContainer> UI_PANELS;
	
	static {
		BASIC_GAME_OBJECTS = create(new BasicRenderer(), "BASIC_GAME_OBJECTS");
		UI_PANELS = create(new UIRenderer(), "UI_PANELS");
	}
	

	
	private List<T> renderables;
	private IRenderer<T> renderer;
	private String name;
	
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
	
	public void render(Dimension dimension, Window window, Camera camera) {
		renderer.render(renderables, dimension, window, camera);
	}

	@Override
	public void init() {
		renderer.init();
	}

	@Override
	public void close() {
		for (Renderable renderable : renderables) {
			renderable.close();
		}
		renderer.close();
	}
	
	

	
}
