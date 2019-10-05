package ch.g_7.graphite.rendering.renderer;

import java.util.List;

import ch.g_7.graphite.base.object.Camera;
import ch.g_7.graphite.core.Window;
import ch.g_7.graphite.rendering.Renderable;
import ch.g_7.util.stuff.Passable;

public interface IRenderer<T extends Renderable> extends Passable {
	
	void render(List<T> renderables, Window window, Camera camera);

}
