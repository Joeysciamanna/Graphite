package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.transform.ITransform;
import ch.g_7.graphite.base.transform.Transform;
import ch.g_7.graphite.node.*;
import ch.g_7.graphite.resource.IResource;

import java.util.ArrayList;
import java.util.List;

public class GameObject<T extends IViewModel> extends AbstractEntity<INode<?,?>, T> implements IResource {


	protected final IEntityId id;
	protected final Transform transform;
	protected final ArrayList<GameObject<?>> children;
	private T viewModel;

	public GameObject(IEntityId id, int abilities, T viewModel) {
		super(id, abilities);
		this.id = id;
		this.viewModel = viewModel;
		this.transform = new Transform();
		this.children = new ArrayList<>();
	}

	public GameObject(IEntityId id, T viewModel) {
		this(id, Updatable.ABILITY | Renderable.ABILITY | Identifiable.ABILITY, viewModel);
	}


	@Override
	public void update(float deltaMillis) {}


	@Override
	public List<? extends INode<?,?>> getChildren() {
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
	public IEntityId getId() {
		return id;
	}

	@Override
	public void close() {}

	@Override
	public void init() {

	}
}
