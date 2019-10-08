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
import org.joml.Vector2i;
import org.joml.Vector3f;

import ch.g_7.graphite.base.entity.Camera;
import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.core.Window;
import ch.g_7.graphite.rendering.Dimension;
import ch.g_7.graphite.rendering.shaderprogram.UIShaderProgram;

public class UIRenderer implements IRenderer<IUIPanel> {

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
	public void render(List<IUIPanel> renderables, Dimension dimension, Window window, Camera camera) {

		shaderProgram.bind();

		shaderProgram.setTextureSampler(0);

		
		// Render each gameItem
		for (IUIPanel uiPanel : renderables) {

			// Set model view matrix for this item
			modelViewMatrix.identity().translate(new Vector3f(uiPanel.getPosition().x,uiPanel.getPosition().y, 0)).scaleXY(uiPanel.getSize().x, uiPanel.getSize().y);
			shaderProgram.setModelViewMatrix(modelViewMatrix);

			shaderProgram.setColor(uiPanel.getColor());

			if (uiPanel.getTexture() != null) {
				// Render the mes for this game item
				// Activate firs texture bank
				glActiveTexture(GL_TEXTURE0);
				// Bind the texture
				glBindTexture(GL_TEXTURE_2D, uiPanel.getTexture().getId());
			}
			// Draw the mesh
			glBindVertexArray(uiPanel.getMesh().getVaoId());
			glEnableVertexAttribArray(0);
			glEnableVertexAttribArray(1);

			glDrawElements(GL_TRIANGLES, uiPanel.getMesh().getVertexCount(), GL_UNSIGNED_INT, 0);

			if (uiPanel.getTexture() != null) {
				// Restore state
				glDisableVertexAttribArray(0);
				glDisableVertexAttribArray(1);
				glBindVertexArray(0);
			}

		}

		shaderProgram.unbind();
	}

	@Override
	public void close() throws Exception {
		shaderProgram.close();
	}

}
