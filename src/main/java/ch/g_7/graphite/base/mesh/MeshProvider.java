package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;


public class MeshProvider extends BasicResourceProvider<Mesh, MeshKey> {

	public final static String NAME = "MESH_PROVIDER";

	@Override
	protected Mesh loadResource(MeshKey resourceKey) throws IllegalArgumentException {
		throw new RuntimeException("not yet implemented yet");
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public IResourceProvider<Mesh, MeshKey> newInstance() {
		return new MeshProvider();
	}

	@Override
	public boolean canProvide(IResourceKey resourceKey) {
		return resourceKey.getResourceName().equals(MeshKey.NAME);
	}
}
