package ch.g_7.graphite.rendering;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.glEnable;

import org.lwjgl.opengl.GL11;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.Dimension;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.resource.ResourceHandler;

public class MasterRenderer implements Initializable, AutoCloseable{

	
	public void render(Dimension dimension, Window window, Camera camera) {

		for (RenderCluster<?,?> renderCluster : dimension.getRenderClasses()) {
			renderCluster.render(window, camera);
		}
		glfwSwapBuffers(window.getId());
		glfwPollEvents();
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	@Override
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}
	
	protected void doInit() {
		glEnable(GL_DEPTH_TEST);

//		glDisable(GL_CULL_FACE);
//		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
//		glEnable(GL_BLEND);
	}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallClose(this)) doClose();
	}

	protected void doClose() {
	}
	

}
