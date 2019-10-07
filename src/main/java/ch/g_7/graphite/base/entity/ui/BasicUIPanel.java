package ch.g_7.graphite.base.entity.ui;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import ch.g_7.graphite.base.viewmodel.IViewModel;

public class BasicUIPanel implements IUIPanel{

	private IViewModel viewModel;
	private Vector2f position;
	private float rotation;
	private float scale;
	
	private Matrix4f viewMatrix;
	
	public BasicUIPanel(IViewModel viewModel, Vector2f position, float rotation, float scale) {
		this.viewModel = viewModel;
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
		this.viewMatrix = new Matrix4f().translate(new Vector3f(position, 0)).rotateZ(rotation).scale(scale);
	}

	public BasicUIPanel(IViewModel viewModel, Vector2f position) {
		this(viewModel, position, 0, 1);
	}
	
	@Override
	public IViewModel getViewModel() {
		return viewModel;
	}
	
	public void setViewModel(IViewModel viewModel) {
		this.viewModel = viewModel;
	}

	@Override
	public Vector2f getPosition() {
		return position;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}

	@Override
	public float getRotation() {
		return rotation;
	}
	
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	@Override
	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	@Override
	public Matrix4f getModelViewMatrix() {
		return viewMatrix;
	}
}
