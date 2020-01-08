package ch.g_7.graphite.rendering;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;

import org.lwjgl.opengl.GL11;

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
		glfwSwapBuffers(window.getId());
		glfwPollEvents();
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	public void init() {
		glEnable(GL_DEPTH_TEST);

		glDisable(GL_CULL_FACE);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glEnable(GL_BLEND);
	}
	
	
	public void close() {}

}
