package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.transformation.Transformation;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.resource.IResource;

import java.util.ArrayList;
import java.util.List;

public class Entity implements IEntity, IResource {


	protected ViewModel viewModel;
	protected final Transformation transformation;
	protected final ArrayList<Entity> childs;

	public Entity(ViewModel viewModel) {
		this.viewModel = viewModel;
		this.transformation = new Transformation();
		this.childs = new ArrayList<Entity>();
	}
	

	@Override
	public void update(float deltaMillis) {}

	@Override
	public List<Entity> getChildren() {
		return childs;
	}

	@Override
	public Transformation getTransformation() {
		return transformation;
	}
	
	@Override
	public ViewModel getViewModel() {
		return viewModel;
	}

	public void setViewModel(ViewModel viewModel) {
		this.viewModel = viewModel;
	}
	
	@Override
	public void close() {}

	@Override
	public void init() {}
}
