package ch.g_7.graphite.core.loop;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.Dimension;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.MasterRenderer;

public class RenderLoop extends Loop {

	private MasterRenderer masterRenderer;
	private Dimension dimension;
	private Window window;
	private Camera camera;
	
	public RenderLoop(MasterRenderer masterRenderer, Dimension dimension, Window window, Camera camera) {
		this.masterRenderer = masterRenderer;
		this.dimension = dimension;
		this.window = window;
		this.camera = camera;
	}

	@Override
	public void run(float deltaMillis) {
		masterRenderer.render(dimension, window, camera);
	}

}
