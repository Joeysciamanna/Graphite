package ch.g_7.graphite.rendering.ui;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;

import java.util.List;

import org.joml.Matrix4f;

import com.sun.org.apache.xpath.internal.axes.ChildIterator;

import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.basic.BasicRenderer;
import ch.g_7.graphite.rendering.basic.BasicShaderProgram;
import ch.g_7.graphite.rendering.transformator.ITransformator;
import ch.g_7.graphite.rendering.transformator.PixelTransformator;
import ch.g_7.graphite.ui.IUIPanel;
import ch.g_7.graphite.ui.IUIRootContainer;
import ch.g_7.graphite.util.Resources;

/**
 * TODO refactor ui rendering put all in shader programm -> performance
 * @author Joey Sciamanna
 *
 */
public class UIRenderer extends BasicRenderer<IUIRootContainer> {
	
	public UIRenderer() {
		super(new BasicShaderProgram(Resources.UI_VERTEX_SHADER, Resources.UI_FRAGMENT_SHADER), new PixelTransformator());
	}


	@Override
	public void renderAll(List<IUIRootContainer> rootContainers) {
		for (IUIRootContainer container : rootContainers) {
			if (container.isVisible()) {
				for (IUIPanel panel : container.getChilds()) {
					renderPanel(panel);
				}
			}
		}
	}


	protected void renderPanel(IUIPanel panel) {
		for (IUIPanel child : panel.getChilds()) {
			if (child.isVisible()) {
				renderPanel(child);
			}
		}
		
		render(panel.getM, transformation);
		
	}


}
