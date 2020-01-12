package ch.g_7.graphite.rendering.draw;

import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;

import java.util.List;

import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.draw.Drawable;
import ch.g_7.graphite.draw.object.IDrawObject;
import ch.g_7.graphite.node.Localizable;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.Renderer;
import ch.g_7.graphite.rendering.entity.EntityShaderProgram;
import ch.g_7.graphite.rendering.entity.EntityTransformation2d;

public class DrawRenderer extends Renderer<Drawable, EntityShaderProgram>{

	private ITransformation<Localizable> transformation;
	
	public DrawRenderer() {
		super(new EntityShaderProgram());
		this.transformation = new EntityTransformation2d();
	}

	@Override
	protected void doRender(List<Drawable> drawables, Window window, Camera camera) {
		shaderProgram.setTextureSampler(0);
		shaderProgram.setProjectionMatrix(transformation.getProjectionMatrix(window, camera));
		
		for (Drawable drawable : drawables) {
			
			for (IDrawObject drawObject : drawable.draw().getDrawObjects()) {
				
				shaderProgram.setModelViewMatrix(transformation.getModelViewMatrix(drawObject));

				shaderProgram.setColor(drawObject.getColor());
				
				if (drawObject.getTexture() != null) {
					drawObject.getTexture().bind();
					shaderProgram.setTextureEnabled(true);
				} else {
					shaderProgram.setTextureEnabled(false);
				}

				VAO vao = drawObject.getMesh().getVAO();
				
				vao.bind();
				glDrawElements(drawObject.getGLDrawMethod(), drawObject.getMesh().getVerticesCount(), GL_UNSIGNED_INT, 0);
				vao.unbind();
				drawObject.getTexture().unbind();
			}
			
		} 

	}
	
	
	public void setTransformation(ITransformation<Localizable> transformation) {
		this.transformation = transformation;
	}

}
