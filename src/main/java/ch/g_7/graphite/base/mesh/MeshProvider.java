package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.util.io.IFileLoader;


public class MeshProvider extends BasicResourceProvider<Mesh, MeshKey> {

	@Override
	protected Mesh loadResource(MeshKey resourceKey, IFileLoader fileLoader) throws IllegalArgumentException {
		checkResourceNames(resourceKey, MeshKey.NAME);
		return new Mesh(resourceKey.getPositions(), resourceKey.getIndices());
	}





	@Override
	public IResourceProvider<Mesh, MeshKey> newInstance() {
		return new MeshProvider();
	}

	@Override
	public boolean canProvide(IResourceKey resourceKey) {
		return containsResourceNames(resourceKey, MeshKey.NAME);
	}

}
