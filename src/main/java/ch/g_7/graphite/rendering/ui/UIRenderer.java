package ch.g_7.graphite.rendering.ui;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;

import java.util.List;

import org.joml.Matrix4f;

import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.Renderer;
import ch.g_7.graphite.ui.IUIPanel;
import ch.g_7.graphite.ui.IUIRootContainer;

/**
 * TODO refactor ui rendering put all in shader programm -> performance
 * @author Joey Sciamanna
 *
 */
public class UIRenderer extends Renderer<IUIRootContainer, UIShaderProgram> {
	
	protected ITransformation<IUIPanel> transformation;

	public UIRenderer() {
		super(new UIShaderProgram()); 
		this.transformation = new UITransformation();
	}


	@Override
	public final void doRender(List<IUIRootContainer> rootContainers, Window window, Camera camera) {
		
		shaderProgram.setTextureSampler(0);
		shaderProgram.setProjectionMatrix(transformation.getProjectionMatrix(window, camera));
		
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
		
		Matrix4f modelViewMatrix = transformation.getModelViewMatrix(panel);

		shaderProgram.setModelViewMatrix(modelViewMatrix);

		shaderProgram.setColor(panel.getColor());
		
		if (panel.getTexture() != null) {
			panel.getTexture().bind();
			shaderProgram.setTextureEnabled(true);
		} else {
			shaderProgram.setTextureEnabled(false);
		}

		VAO vao = panel.getMesh().getVAO();
		
		vao.bind();
		glDrawElements(GL_TRIANGLES, panel.getMesh().getVerticesCount(), GL_UNSIGNED_INT, 0);
		vao.unbind();
		if(panel.getTexture() != null) {
			panel.getTexture().unbind();
		}
	
		
	}


}
