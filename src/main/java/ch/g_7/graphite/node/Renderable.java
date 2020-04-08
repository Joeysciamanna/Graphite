package ch.g_7.graphite.node;

import ch.g_7.graphite.base.transform.IROTransform;

public interface Renderable<T extends IViewModel> {

	T getViewModel();
	
	IROTransform getTransform();
	
}
