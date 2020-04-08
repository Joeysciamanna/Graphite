package ch.g_7.graphite.entity;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.transform.ITransform;
import ch.g_7.graphite.base.transform.Transform;
import ch.g_7.graphite.node.IEntity;
import ch.g_7.graphite.node.IEntityIdentifier;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.resource.IResource;

public class GameObject<T extends IViewModel> implements IEntity<T>, IResource {


	protected final IEntityIdentifier<?> id;
	protected final Transform transform;
	protected final ArrayList<GameObject<?>> children;
	private T viewModel;

	public GameObject(IEntityIdentifier<?> id, T viewModel) {
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
	public IEntityIdentifier<?> getId() {
		return id;
	}

	@Override
	public void close() {}

	@Override
	public void init() {}


}
