package ch.g_7.graphite.rendering.renderer;

import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity2d.IEntity;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.shaderprogram.EntityShaderProgram;

public class Entity2dRenderer extends BasicRenderer<EntityShaderProgram, IEntity> implements ITransformation<IEntity>{

	private Matrix4f viewMatrix;
	
	private IEntity entity;
	
	public Entity2dRenderer() {
		super(new EntityShaderProgram());
		viewMatrix = new Matrix4f();
	}
	
	
	@Override
	protected void renderAll(List<IEntity> renderables) {
		for (IEntity entity : renderables) {
			render(entity, this);
		}
	}
	
	
	@Override
	protected void prepareTransformation(Window window, Camera camera) {
		viewMatrix.identity();
		viewMatrix.translate((float) -camera.getPosition().x(), (float) -camera.getPosition().y(),
				(float) -camera.getPosition().z());
	}
	
	
	@Override
	public void prepareFor(IEntity r) {
		this.entity = r;
	}

	@Override
	public Matrix4f getViewMatrix() {
		Matrix4f viewCurr = new Matrix4f(viewMatrix);
		return viewCurr.translate(entity.getPosition()).rotateXYZ(new Vector3f(entity.getRotation())).scale(entity.getScale());
	}
	

}
