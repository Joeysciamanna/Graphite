package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.util.io.IResourceLoader;


public class MeshProvider extends BasicResourceProvider<Mesh, Mesh> {

	@Override
	protected Mesh loadResource(Mesh mesh, IResourceLoader resourceLoader) throws IllegalArgumentException {
		return mesh;
	}


	@Override
	public IResourceProvider<Mesh, Mesh> newInstance() {
		return new MeshProvider();
	}

	@Override
	public boolean canProvide(IResourceKey resourceKey) {
		return containsResourceNames(resourceKey, Mesh.NAME);
	}

}
