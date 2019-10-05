package ch.g_7.graphite.rendering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.g_7.graphite.base.object.AbstractGameEntity;
import ch.g_7.graphite.base.object.Camera;
import ch.g_7.graphite.core.Window;
import ch.g_7.graphite.rendering.renderclass.RenderClass;
import ch.g_7.graphite.util.Pos3d;

public final class Dimension {

	
	private List<RenderClass<?>> renderClasses;
	
	
	public Dimension() {
		renderClasses = new ArrayList<>(20);
	}
	
	public <T extends Renderable> void addObj(T renderable, RenderClass<T> renderClass) {
		if(!renderClasses.contains(renderClass)) {
			renderClasses.add(renderClass);
		}
		renderClass.add(renderable);
	}
	
	public List<RenderClass<?>> getRenderClasses() {
		return renderClasses;
	}
	
	public void render(Window window, Camera camera) {
		for (RenderClass<?> renderClass : renderClasses) {
			renderClass.render(window, camera);
		}
	}
	
	
}
