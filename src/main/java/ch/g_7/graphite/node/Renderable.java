package ch.g_7.graphite.node;

import ch.g_7.graphite.base.transformation.IROTransform;

public interface Renderable<T extends IViewModel> {

	T getViewModel();
	
	IROTransform getTransform();
	
}
