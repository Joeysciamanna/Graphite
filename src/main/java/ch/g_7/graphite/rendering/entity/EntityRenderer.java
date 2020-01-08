package ch.g_7.graphite.rendering.entity;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

import java.util.List;

import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.entity.Entity;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.Renderer;

public class EntityRenderer extends Renderer<Entity, EntityShaderProgram> {

	protected ITransformation<Entity> transformation;

	public EntityRenderer() {
		super(new EntityShaderProgram());
		this.transformation = new EntityTransformation2d();
	}


	@Override
	public final void doRender(List<Entity> gameObjects, Window window, Camera camera) {
		
		shaderProgram.setTextureSampler(0);
		shaderProgram.setProjectionMatrix(transformation.getProjectionMatrix(window, camera));
		
		for (Entity gameObject : gameObjects) {

			ViewModel viewModel = gameObject.getViewModel();
					
			shaderProgram.setModelViewMatrix(transformation.getModelViewMatrix(gameObject));

			shaderProgram.setColor(viewModel.getColor());
			
			if (viewModel.getTexture() != null) {
				glActiveTexture(GL_TEXTURE0);
				glBindTexture(GL_TEXTURE_2D, viewModel.getTexture().getId());
				shaderProgram.setTextureEnabled(true);
			} else {
				shaderProgram.setTextureEnabled(false);
			}

			VAO vao = viewModel.getMesh().getVAO();
			
			vao.bind();
			glDrawElements(GL_TRIANGLES, viewModel.getMesh().getVerticesCount(), GL_UNSIGNED_INT, 0);
			vao.unbind();
		}

	}
	
	
	public void setTransformation(ITransformation<Entity> transformation) {
		this.transformation = transformation;
	}


}
