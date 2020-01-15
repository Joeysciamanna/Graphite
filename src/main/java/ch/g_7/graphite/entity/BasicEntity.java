package ch.g_7.graphite.entity;

import ch.g_7.graphite.util.Resources;
import ch.g_7.util.resource.Resource;
import org.joml.Vector3fc;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Localizable;
import ch.g_7.graphite.util.ResourceHandler;

public abstract class BasicEntity extends Resource implements INode, Localizable {
	
	@Override
	protected void doInit() {
		if(getViewModel()!=null) getViewModel().init();
	}

	@Override
	protected void doClose() {
		if(getViewModel()!=null) getViewModel().close();
	}
	
	@Override
	public void update(double deltaMillis) {}

	public abstract float getScale();
	
	public abstract Vector3fc getRotation();
	
	public abstract ViewModel getViewModel();

	public abstract Vector3fc getPosition();
	
	
}
