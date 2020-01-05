package ch.g_7.graphite.rendering.renderer;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.shaderprogram.EntityShaderProgram;

public class Entity2dRenderer extends BasicRenderer<EntityShaderProgram, IEntity, IEntity>{
	
	public Entity2dRenderer() {
		super(new EntityShaderProgram(), new Transformation());
	}
	
	
	private static class Transformation implements ITransformation<IEntity>{
		
		private Matrix4f projectionMatrix;
		private Matrix4f modelViewMatrix;
		
		public Transformation() {
			projectionMatrix = new Matrix4f();
			modelViewMatrix = new Matrix4f();
		}
		
		@Override
		public Matrix4f getProjectionMatrix(Window window, Camera camera) {
			return projectionMatrix.identity().translate((float) -camera.getPosition().x(), (float) -camera.getPosition().y(),
					(float) -camera.getPosition().z());
		}
		
		@Override
		public Matrix4f getModelViewMatrix(IEntity entity) {
			return modelViewMatrix.identity().translate(entity.getPosition()).rotateXYZ(new Vector3f(entity.getRotation())).scale(entity.getScale());
		}

	}

	

}
