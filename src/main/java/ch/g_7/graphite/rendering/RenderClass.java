package ch.g_7.graphite.rendering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.renderer.Entity2dRenderer;
import ch.g_7.graphite.rendering.renderer.IRenderer;
import ch.g_7.graphite.rendering.renderer.UIRenderer;
import ch.g_7.graphite.ui.IUIRootContainer;
import ch.g_7.util.able.Initializable;

public class RenderClass<T extends Renderable> implements Initializable, AutoCloseable{
	
	private static final Map<String, RenderClass<?>> RENDER_CLASSES = new HashMap<>();
	
	public static final RenderClass<IEntity> ENTITIES_2D;
	public static final RenderClass<IEntity> ENTITIES_3D;
	public static final RenderClass<IUIRootContainer> UI;
	
	static {
		ENTITIES_2D = create(new Entity2dRenderer(), "ENTITIES_2D");
		ENTITIES_3D = create(new Entity2dRenderer(), "ENTITIES_3D");
		UI = create(new UIRenderer(), "UI_PANELS");
	}
	

	
	private List<T> renderables;
	private IRenderer<T> renderer;
	private List<Function<T, T>> rules;
	private String name;
	
	public RenderClass(IRenderer<T> renderer, String name, int size) {
		this.renderables = new ArrayList<>(size);
		this.renderer = renderer;
		this.rules = new ArrayList<>();
		this.name = name;
	}
	
	public void add(T renderalbe) {
		for (Function<T, T> rule : rules) {
			renderalbe = rule.apply(renderalbe);
		}
		renderables.add(renderalbe);
	}
	
	public void addRule(Function<T, T> rule) {
		rules.add(rule);
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
