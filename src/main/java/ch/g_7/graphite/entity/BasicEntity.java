package ch.g_7.graphite.entity;

import org.joml.Vector3f;

public class BasicEntity extends Entity {

	private ViewModel viewModel;
	private Vector3f position;
	private Vector3f rotation;
	private float scale = 1;
	
	public BasicEntity(ViewModel viewModel, Vector3f position) {
		this();
		this.viewModel = viewModel;
		this.position = position;
	}
	
	public BasicEntity() {
		this.position = new Vector3f();
		this.rotation = new Vector3f();
		this.viewModel = new ViewModel();
	}
	
	@Override
	public Vector3f getPosition() {
		return position;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	@Override
	public float getScale() {
		return scale;
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}

	@Override
	public Vector3f getRotation() {
		return rotation;
	}
	
	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}	

	@Override
	public ViewModel getViewModel() {
		return viewModel;
	}
	
	public void setViewModel(ViewModel viewModel) {
		this.viewModel = viewModel;
	}

}
