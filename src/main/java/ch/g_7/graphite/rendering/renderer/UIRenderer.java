package ch.g_7.graphite.rendering.renderer;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.IUIRootContainer;
import ch.g_7.graphite.rendering.Dimension;
import ch.g_7.graphite.rendering.shaderprogram.UIShaderProgram;

public class UIRenderer implements IRenderer<IUIRootContainer> {

	private UIShaderProgram shaderProgram;
	
	private Matrix4f modelViewMatrix;

	public UIRenderer() {
		shaderProgram = new UIShaderProgram();
		modelViewMatrix = new Matrix4f();
	}

	@Override
	public void init() {
		shaderProgram.init();
	}

	@Override
	public void render(List<IUIRootContainer> renderables, Dimension dimension, Window window, Camera camera) {

		shaderProgram.bind();

		shaderProgram.setTextureSampler(0);

		// Render each gameItem
		for (IUIRootContainer container : renderables) {
			if(container.isVisible()) {
				for (IUIPanel panel : container.getChilds()) {
					render(panel);
				}
			}
		}

		shaderProgram.unbind();
	}
	
	
	private void render(IUIPanel panel) {
		
		for (IUIPanel child : panel.getChilds()) {
			if(child.isVisible()) {
				render(child);
			}
		}
		
		// Set model view matrix for this item
		modelViewMatrix.identity().translate(new Vector3f(panel.getPosition().getXValue() - 1 , panel.getPosition().getYValue()*-1 + 1, -0.9f)).scaleXY(panel.getSize().getXValue(), panel.getSize().getYValue());
		shaderProgram.setModelViewMatrix(modelViewMatrix);

		shaderProgram.setColor(panel.getColor());

		if (panel.getTexture() != null) {
			// Render the mes for this game item
			// Activate firs texture bank
			glActiveTexture(GL_TEXTURE0);
			// Bind the texture
			glBindTexture(GL_TEXTURE_2D, panel.getTexture().getId());
		}
		// Draw the mesh
		glBindVertexArray(panel.getMesh().getVaoId());
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);

		glDrawElements(GL_TRIANGLES, panel.getMesh().getVertexCount(), GL_UNSIGNED_INT, 0);

		if (panel.getTexture() != null) {
			// Restore state
			glDisableVertexAttribArray(0);
			glDisableVertexAttribArray(1);
			glBindVertexArray(0);
		}
	}

	@Override
	public void close() {
		shaderProgram.close();
	}

}
