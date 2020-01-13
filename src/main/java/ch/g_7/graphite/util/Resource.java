package ch.g_7.graphite.util;

import ch.g_7.util.able.Initializable;

public abstract class Resource implements AutoCloseable, Initializable {

	@Override
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}
	
	protected abstract void doInit();
	
	@Override
	public final void close() {
		if(ResourceHandler.shallClose(this)) doClose();
	}

	protected abstract void doClose();
	
}
