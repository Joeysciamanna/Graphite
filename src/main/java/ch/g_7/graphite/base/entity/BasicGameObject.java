package ch.g_7.graphite.base.entity;

import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import ch.g_7.graphite.base.viewmodel.IViewModel;

public class BasicGameObject implements IGameObject{

	private IViewModel viewModel;
	private Vector3f position;
	private Vector3f rotation;
	private float scale;
	
	
	public BasicGameObject(IViewModel viewModel, Vector3f position, Vector3f rotation, float scale) {
		this.viewModel = viewModel;
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}
	
	public BasicGameObject(IViewModel viewModel, Vector3f position) {
		this(viewModel, position, new Vector3f(), 1);
	}

	@Override
	public Matrix4fc getModelViewMatrix() {
		return new Matrix4f().translate(position).rotateXYZ(rotation).scale(scale);
	}

	public void setViewModel(IViewModel viewModel) {
		this.viewModel = viewModel;
	}

	@Override
	public IViewModel getViewModel() {
		return viewModel;
	}
	
	@Override
	public Vector3fc getPosition() {
		return position;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	@Override
	public Vector3fc getRotation() {
		return rotation;
	}
	
	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	@Override
	public float getScale() {
		return scale;
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}

}
