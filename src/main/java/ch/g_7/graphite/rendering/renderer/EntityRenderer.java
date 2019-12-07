package ch.g_7.graphite.rendering.renderer;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.base.entity.IEntity;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.RenderClass;
import ch.g_7.graphite.rendering.shaderprogram.EntityShaderProgram;

public class EntityRenderer extends BasicRenderer<EntityShaderProgram, IEntity, RenderClass<IEntity>> implements ITransformation<IEntity>{

	private Matrix4f viewMatrix;
	
	private IEntity entity;
	
	public EntityRenderer() {
		super(new EntityShaderProgram());
		viewMatrix = new Matrix4f();
	}
	
	
	@Override
	protected void renderAll(RenderClass<IEntity> renderClass) {
		for (IEntity entity : renderClass.getAll()) {
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
