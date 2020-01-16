package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.transformation.Transformation;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.util.resource.IDepender;
import ch.g_7.util.resource.Resource;

public class Entity extends Resource implements IEntity, IDepender {

	private ViewModel viewModel;
	private Transformation transformation;
	
	public Entity() {
		this.viewModel = new ViewModel();
		this.transformation = new Transformation();
	}
	
	@Override
	public ViewModel getViewModel() {
		return viewModel;
	}

	@Override
	public Transformation getTransformation() {
		return transformation;
	}
	
	public void setViewModel(ViewModel viewModel) {
		this.viewModel = viewModel;
	}
	
	public void setTransformation(Transformation transformation) {
		this.transformation = transformation;
	}

	@Override
	public void update(float deltaMillis) {}

	protected void doInit() {
		if(viewModel!=null) viewModel.bind(this);
	}

	protected void doClose() {
		if(viewModel!=null) viewModel.unbind(this);
	}
	

}
