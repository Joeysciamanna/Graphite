package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;


public class MeshProvider extends BasicResourceProvider<Mesh, IMeshKey> {

	public final static String NAME = "MESH_PROVIDER";

	@Override
	protected Mesh loadResource(IMeshKey resourceKey) throws IllegalArgumentException {
		if(resourceKey.getResourceName().equals(MeshType.NAME)){
			return loadMeshType((MeshType) resourceKey);
		}
		return loadMeshBuilder((MeshKeyBuilder2d) resourceKey);
	}

	private Mesh loadMeshType(MeshType meshType){
		throw new RuntimeException("not yet implemented");
	}

	private Mesh loadMeshBuilder(MeshKeyBuilder2d meshKeyBuilder2d){
		return meshKeyBuilder2d.build();
	}


	@Override
	public IResourceProvider<Mesh, IMeshKey> newInstance() {
		return new MeshProvider();
	}

	@Override
	public boolean canProvide(IResourceKey resourceKey) {
		return resourceKey.getResourceName().equals(MeshType.NAME) || resourceKey.getResourceName().equals(MeshKeyBuilder2d.NAME);
	}

}
