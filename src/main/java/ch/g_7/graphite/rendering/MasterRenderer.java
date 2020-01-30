package ch.g_7.graphite.rendering;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.glEnable;

import org.lwjgl.opengl.GL11;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.Dimension;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.util.resource.Resource;

public class MasterRenderer extends Resource {

	
	public void render(Dimension dimension, Window window, Camera camera) {

		for (RenderClass<?,?> renderCluster : dimension.getRenderClasses()) {
			renderCluster.render(window, camera);
		}
		glfwSwapBuffers(window.getId());
		glfwPollEvents();
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	
	protected void doInit() {
		glEnable(GL_DEPTH_TEST);

		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		glEnable(GL11.GL_BLEND);
	}
	

	protected void doClose() {
	}
	

}
