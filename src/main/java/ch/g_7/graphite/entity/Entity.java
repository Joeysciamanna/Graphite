package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.transformation.ITransformation;
import ch.g_7.graphite.base.transformation.Transformation;
import ch.g_7.graphite.base.view_model.IViewModel;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.util.resource.Resource;

public class Entity extends Resource implements IEntity {

	private ViewModel viewModel;
	private Transformation transformation;
	
	@Override
	public IViewModel getViewModel() {
		return viewModel;
	}

	@Override
	public ITransformation getTransformation() {
		return transformation;
	}

	@Override
	public void update(double deltaMillis) {}

	protected void doInit() {
		if(getViewModel()!=null) getViewModel().init();
	}

	protected void doClose() {
		if(getViewModel()!=null) getViewModel().close();
	}
	

}
