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

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.BasicRenderable;
import ch.g_7.graphite.rendering.Dimension;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.RenderClass;
import ch.g_7.graphite.rendering.Renderable;
import ch.g_7.graphite.rendering.shaderprogram.BasicShaderProgram;

public abstract class BasicRenderer<S extends BasicShaderProgram, R extends Renderable> implements IRenderer<R> {

	protected S shaderProgram;

	public BasicRenderer(S shaderProgram) {
		this.shaderProgram = shaderProgram;
	}


	@Override
	public void render(RenderClass<R> renderClass, Dimension dimension, Window window, Camera camera) {
		
		before(renderClass, dimension, window, camera);
		
		renderAll(renderClass.getAll());

		after(renderClass, dimension, window, camera);
	}
	
	
	protected abstract void renderAll(List<R> renderables);

	protected <T extends BasicRenderable> void render(T r, ITransformation<T> transformation) {
		// Set model view matrix for this item

		
		Matrix4f modelViewMatrix = transformation.getViewMatrix(r);
//					
//					Matrix4f viewCurr = new Matrix4f(viewMatrix);
//					modelViewMatrix = viewCurr.mul(object.getModelViewMatrix());//TODO CHANGE

		shaderProgram.setModelViewMatrix(modelViewMatrix);

		shaderProgram.setColor(r.getColor());

		if (r.getTexture() != null) {
			// Render the mes for this game item
			// Activate firs texture bank
			glActiveTexture(GL_TEXTURE0);
			// Bind the texture
			glBindTexture(GL_TEXTURE_2D, r.getTexture().getId());

			shaderProgram.setTextureEnabled(true);
		} else {
			shaderProgram.setTextureEnabled(false);
		}
		// Draw the mesh
		glBindVertexArray(r.getMesh().getVaoId());
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);

		glDrawElements(GL_TRIANGLES, r.getMesh().getVertexCount(), GL_UNSIGNED_INT, 0);

		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		glBindVertexArray(0);
	}

	protected void before(RenderClass<R> renderClass, Dimension dimension, Window window, Camera camera) {
		shaderProgram.bind();

		prepareTransformation(window, camera);
//		viewMatrix.identity();
//		viewMatrix.translate((float) -camera.getPosition().x(), (float) -camera.getPosition().y(),
//				(float) -camera.getPosition().z());

		shaderProgram.setTextureSampler(0);
	}

	protected abstract void prepareTransformation(Window window, Camera camera);
	

//	transformation.setCamera(camera);
//	transformation.setWindow(window);
	
	protected void after(RenderClass<R> renderClass, Dimension dimension, Window window, Camera camera) {
		shaderProgram.unbind();
	}


	@Override
	public void init() {
		shaderProgram.init();
	}
	
	@Override
	public void close() {
		shaderProgram.close();
	}
	


}
