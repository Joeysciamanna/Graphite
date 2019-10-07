package ch.g_7.graphite.rendering.renderer;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector2i;

import ch.g_7.graphite.base.entity.object.Camera;
import ch.g_7.graphite.base.entity.object.IGameObject;
import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.core.Window;
import ch.g_7.graphite.rendering.Dimension;
import ch.g_7.graphite.rendering.shaderprogram.UIShaderProgram;

public class UIRenderer implements IRenderer<IUIPanel> {

	private UIShaderProgram shaderProgram;

	public UIRenderer() {
		shaderProgram = new UIShaderProgram();
	}

	@Override
	public void init() {
		shaderProgram.init();
	}

	@Override
	public void render(List<IUIPanel> renderables, Dimension dimension, Window window, Camera camera) {

		shaderProgram.bind();

		shaderProgram.setTextureSampler(0);

		shaderProgram.setWindowSize(new Vector2i(window.getWidth(), window.getHeight()));
		// Render each gameItem
		for (IUIPanel uiPanel : renderables) {

			// Set model view matrix for this item
	


			shaderProgram.setColor(uiPanel.getViewModel().getColor());

			if (uiPanel.getViewModel().getTexture() != null) {
				// Render the mes for this game item
				// Activate firs texture bank
				glActiveTexture(GL_TEXTURE0);
				// Bind the texture
				glBindTexture(GL_TEXTURE_2D, uiPanel.getViewModel().getTexture().getId());
			}
			// Draw the mesh
			glBindVertexArray(uiPanel.getViewModel().getMesh().getVaoId());
			glEnableVertexAttribArray(0);
			glEnableVertexAttribArray(1);

			glDrawElements(GL_TRIANGLES, uiPanel.getViewModel().getMesh().getVertexCount(), GL_UNSIGNED_INT, 0);

			if (uiPanel.getViewModel().getTexture() != null) {
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
