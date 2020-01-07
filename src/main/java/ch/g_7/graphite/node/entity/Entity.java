package ch.g_7.graphite.node.entity;

import org.joml.Vector3f;
import org.joml.Vector3fc;

import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.node.INode;

public abstract class Entity implements INode {
	

	@Override
	public void init() {}

	@Override
	public void close() {}

	@Override
	public void update(long deltaMillis) {}

	public abstract float getScale();
	
	public abstract Vector3f getRotation();
	
	public abstract ViewModel getViewModel();

	public abstract Vector3fc getPosition();
}
