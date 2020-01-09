package ch.g_7.graphite.rendering.draw;

import java.util.List;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.draw.Drawable;
import ch.g_7.graphite.rendering.Renderer;

public class DrawRenderer extends Renderer<Drawable, DrawShaderProgram>{

	public DrawRenderer() {
		super(new DrawShaderProgram());
	}

	@Override
	protected void doRender(List<Drawable> drawables, Window window, Camera camera) {
//		shaderProgram.setTextureSampler(0);
//		shaderProgram.setProjectionMatrix(transformation.getProjectionMatrix(window, camera));
		
//		for (Drawable drawable : drawables) {

//			ViewModel viewModel = gameObject.getViewModel();
					
//			shaderProgram.setModelViewMatrix(transformation.getModelViewMatrix(gameObject));

//			shaderProgram.setColor(viewModel.getColor());
			
//			if (viewModel.getTexture() != null) {
//				glActiveTexture(GL_TEXTURE0);
//				glBindTexture(GL_TEXTURE_2D, viewModel.getTexture().getId());
//				shaderProgram.setTextureEnabled(true);
//			} else {
//				shaderProgram.setTextureEnabled(false);
//			}
//
//			VAO vao = viewModel.getMesh().getVAO();
//			
//			vao.bind();
//			glDrawElements(GL_TRIANGLES, viewModel.getMesh().getVerticesCount(), GL_UNSIGNED_INT, 0);
//			vao.unbind();
//		} TODO

	}

}
