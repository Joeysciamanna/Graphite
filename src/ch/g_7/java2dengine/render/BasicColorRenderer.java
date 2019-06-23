package ch.g_7.java2dengine.render;

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

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.java2dengine.base.object.AbstractGameEntity;
import ch.g_7.java2dengine.base.object.Camera;
import ch.g_7.java2dengine.core.Dimension;
import ch.g_7.java2dengine.core.Engine;
import ch.g_7.java2dengine.core.Window;
import ch.g_7.java2dengine.util.Pos3d;

public class BasicColorRenderer extends AbstractRenderer {
    
	private BasicColorShaderProgram shaderProgram;


	private Matrix4f viewMatrix;
	
	private Matrix4f modelViewMatrix;
	
	public BasicColorRenderer(BasicColorShaderProgram shaderProgram) {
		this.shaderProgram = shaderProgram;
		viewMatrix = new Matrix4f();
		modelViewMatrix = new Matrix4f();
	}

	@Override
	public void init(Engine engine) {
		shaderProgram.init();
	}

	@Override
	public void render(Window window, Camera camera, Dimension dimension) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		shaderProgram.bind();
	    
	    viewMatrix.identity();
	    viewMatrix.translate(-camera.getPosition().getX(), -camera.getPosition().getY(),-camera.getPosition().getZ());
	    
		// Render each gameItem
		for (AbstractGameEntity object : dimension.getGameObjects()) {
			if (object.render()) {
				
				// Set model view matrix for this item
		    	Pos3d pos = object.getPosition();
		        modelViewMatrix.identity().translate(new Vector3f(pos.getX(), pos.getY(), pos.getZ()))
		        .scale(object.getScale());
		        Matrix4f viewCurr = new Matrix4f(viewMatrix);
		        modelViewMatrix = viewCurr.mul(modelViewMatrix);
				
			
				shaderProgram.setModelViewMatrix(modelViewMatrix);
				shaderProgram.setColor(object.getViewModel().getColor());
				
				// Draw the mesh
				glBindVertexArray(object.getViewModel().getMesh().getVaoId());
				glEnableVertexAttribArray(0);
				glEnableVertexAttribArray(1);

				glDrawElements(GL_TRIANGLES, object.getViewModel().getMesh().getVertexCount(), GL_UNSIGNED_INT, 0);

				// Restore state
				glDisableVertexAttribArray(0);
				glDisableVertexAttribArray(1);
				glBindVertexArray(0);
			}

		}

		shaderProgram.unbind();
	}

	@Override
	public void close() {
		shaderProgram.close();
	}

}
