package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;

public class ViewModelProvider extends BasicResourceProvider<ViewModel, ViewModelKey>{

	public final static String NAME = "VIEW_MODEL_PROVIDER";

	@Override
	public boolean canProvide(IResourceKey resourceKey) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public IResourceProvider<ViewModel, ViewModelKey> newInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ViewModel loadResource(ViewModelKey resourceKey) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getName() {
		return NAME;
	}

}
