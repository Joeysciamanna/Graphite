package ch.g_7.graphite.base.entity.ui;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import ch.g_7.graphite.base.viewmodel.IViewModel;
import ch.g_7.graphite.rendering.Renderable;

public interface IUIPanel extends Renderable {

	public Matrix4f getModelViewMatrix();
	
	public IViewModel getViewModel();
	
	public Vector2f getPosition();
	
	public float getRotation();
	
	public float getScale();
	
}
