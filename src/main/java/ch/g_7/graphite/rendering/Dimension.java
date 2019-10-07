package ch.g_7.graphite.rendering;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.entity.object.Camera;
import ch.g_7.graphite.core.Window;

public final class Dimension {

	
	private List<RenderClass<?>> renderClasses;
	
	
	public Dimension() {
		renderClasses = new ArrayList<>(20);
	}
	
	public <T extends Renderable> void addObj(T renderable, RenderClass<T> renderClass) {
		if(!renderClasses.contains(renderClass)) {
			renderClasses.add(renderClass);
			renderClass.init();
		}
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
	
	
}
