package ch.g_7.graphite.entity;

import org.joml.Vector3fc;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Localizable;
import ch.g_7.graphite.util.ResourceHandler;

public abstract class BasicEntity implements INode, Localizable {
	

	@Override
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}
	
	protected void doInit() {
		if(getViewModel()!=null) getViewModel().init();
	}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallInitialize(this)) doClose();
	}

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
