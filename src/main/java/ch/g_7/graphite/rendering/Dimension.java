package ch.g_7.graphite.rendering;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.entity.Camera;
import ch.g_7.graphite.core.Window;

public final class Dimension {

	
	private List<RenderClass<?>> renderClasses;
	
	private short renderCount;
	
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
			if(renderCount%renderClass.getPrirority()==0) {
				renderClass.render(this, window, camera);
			}
		}
		renderCount++;
	}
	
	
}
