package ch.g_7.graphite.entity;

import org.joml.Vector3fc;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Localizable;

public abstract class BasicEntity implements INode, Localizable {
	

	@Override
	public void init() {
		if(getViewModel()!=null) getViewModel().init();
	}

	@Override
	public void close() {
		if(getViewModel()!=null) getViewModel().close();
	}

	@Override
	public void update(double deltaMillis) {}

	public abstract float getScale();
	
	public abstract Vector3fc getRotation();
	
	public abstract ViewModel getViewModel();

	public abstract Vector3fc getPosition();
}
