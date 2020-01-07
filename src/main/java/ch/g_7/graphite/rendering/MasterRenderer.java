package ch.g_7.graphite.rendering;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.Dimension;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.RenderCluster;
import ch.g_7.util.able.Initializable;

public class MasterRenderer implements Initializable, AutoCloseable{

	
	public void render(Dimension dimension, Window window, Camera camera) {
		for (RenderCluster<?,?> renderCluster : dimension.getRenderClasses()) {
			renderCluster.render(window, camera);
		}
	}
	
	public void init() {}
	
	
	public void close() {}

}
