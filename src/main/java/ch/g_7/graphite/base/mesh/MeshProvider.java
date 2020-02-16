package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;

/**
 * ResourceName must be *.mesh
 */
public class MeshProvider extends BasicResourceProvider<Mesh, MeshKey> {

    public final static String NAME = "MESH_PROVIDER";

    @Override
    protected Mesh loadResource(String resourceName) throws IllegalArgumentException {
        throw new RuntimeException("not yet implemented yet");
    }

    @Override
    public boolean canProvide(IResourceKey resourceName) {
        return resourceName.endsWith(".mesh");
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public IResourceProvider<Mesh, MeshKey> newInstance() {
        return new MeshProvider();
    }
}
