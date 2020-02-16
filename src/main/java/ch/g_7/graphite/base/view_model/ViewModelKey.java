package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.resource.IResourceKey;

public class ViewModelKey implements IResourceKey {

	public final static String NAME = "VIEW_MODEL";
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	@Override
	public String getResourceName() {
		return NAME;
	}

}
