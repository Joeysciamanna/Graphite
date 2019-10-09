package ch.g_7.graphite.base.entity;

import org.joml.Matrix4fc;
import org.joml.Vector3fc;

import ch.g_7.graphite.base.viewmodel.IViewModel;
import ch.g_7.graphite.rendering.Renderable;

public interface IGameObject extends Renderable {

	public IViewModel getViewModel();
	
	public Vector3fc getPosition();
	
	public Vector3fc getRotation();
	
	public Matrix4fc getModelViewMatrix();
	
	public float getScale();
	
}
