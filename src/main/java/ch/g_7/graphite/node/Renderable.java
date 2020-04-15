package ch.g_7.graphite.node;

import ch.g_7.graphite.base.transform.IROTransform;

public interface Renderable<T extends IViewModel> {

	int ABILITY = NodeAbilityProvider.getInstance().next("renderable");

	T getViewModel();
	
	IROTransform getTransform();
	
}
