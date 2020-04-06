package ch.g_7.graphite.entity;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.transformation.IROTransform;
import ch.g_7.graphite.base.transformation.ITransform;
import ch.g_7.graphite.base.transformation.Transform;
import ch.g_7.graphite.node.INodeIdentifier;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.resource.IResource;

public class Entity<T extends IViewModel> implements IEntity<T>, IResource {


	protected final INodeIdentifier<?> id;
	protected final Transform transform;
	protected final ArrayList<Entity<?>> children;
	private T viewModel;

	public Entity(INodeIdentifier<?> id, T viewModel) {
		this.id = id;
		this.viewModel = viewModel;
		this.transform = new Transform();
		this.children = new ArrayList<>();
	}

	@Override
	public void update(float deltaMillis) {}


	@Override
	public List<? extends IEntity<?>> getChildren() {
		return children;
	}

	@Override
	public T getViewModel() {
		return viewModel;
	}

	@Override
	public ITransform getTransform() {
		return transform;
	}

	@Override
	public INodeIdentifier<?> getId() {
		return id;
	}

	@Override
	public void close() {}

	@Override
	public void init() {}


}
