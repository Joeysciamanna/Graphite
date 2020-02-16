package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.IResourceKey;

public class MeshKey implements IResourceKey {

	public static final String NAME = "MESH";
	
	
	@Override
	public String getResourceName() {
		return NAME;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

}
