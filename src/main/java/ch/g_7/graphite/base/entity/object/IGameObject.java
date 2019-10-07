package ch.g_7.graphite.base.entity.object;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.base.viewmodel.IViewModel;
import ch.g_7.graphite.rendering.Renderable;

public interface IGameObject extends Renderable {

	public IViewModel getViewModel();
	
	public Vector3f getPosition();
	
	public Vector3f getRotation();
	
	public Matrix4f getModelViewMatrix();
	
	public double getScale();
	
}
