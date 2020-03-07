package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.transformation.Transform;
import ch.g_7.graphite.base.view_model.ViewModel;

public class Entity implements IEntity {

	private ViewModel viewModel;
	private Transform transformation;


	public Entity(ViewModel viewModel) {
		this.viewModel = viewModel;
		this.transformation = new Transform();
	}
	
	@Override
	public ViewModel getViewModel() {
		return viewModel;
	}

	@Override
	public Transform getTransformation() {
		return transformation;
	}
	
	public void setViewModel(ViewModel viewModel) {
		this.viewModel = viewModel;
	}
	
	public void setTransformation(Transform transformation) {
		this.transformation = transformation;
	}

	@Override
	public void update(float deltaMillis) {}


	@Override
	public void close() { }

}
