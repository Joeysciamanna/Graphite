package ch.g_7.graphite.rendering;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.Window;

public final class Dimension implements AutoCloseable {

	
	private List<RenderClass<?>> renderClasses;
	
	public Dimension() {
		renderClasses = new ArrayList<>(20);
	}
	
	public <T extends Renderable> void addObj(T renderable, RenderClass<T> renderClass) {
		if(!renderClasses.contains(renderClass)) {
			renderClasses.add(renderClass);
			renderClass.init();
		}
		renderable.init();
		renderClass.add(renderable);
	}
	
	public List<RenderClass<?>> getRenderClasses() {
		return renderClasses;
	}
	
	public void render(Window window, Camera camera) {
		for (RenderClass<?> renderClass : renderClasses) {
			renderClass.render(this, window, camera);
		}
	}

	@Override
	public void close() {
		for (RenderClass<?> renderClass : renderClasses) {
			renderClass.close();
		}
	}
	
	
	
}
