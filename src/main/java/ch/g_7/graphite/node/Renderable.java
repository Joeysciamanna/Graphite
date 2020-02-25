package ch.g_7.graphite.node;

import ch.g_7.graphite.base.transformation.ITransformation;
import ch.g_7.graphite.base.view_model.IViewModel;

public interface Renderable {

	IViewModel getViewModel();
	
	ITransformation getTransformation();
	
}
