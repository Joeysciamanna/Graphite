package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.BasicResourceProvider;

import java.io.InvalidObjectException;

/**
 * ResourceName must be *.mesh
 */
public class MeshProvider extends BasicResourceProvider<Mesh> {



    @Override
    protected Mesh loadResource(String resourceName) throws IllegalArgumentException {
        throw new RuntimeException("not yet implemented yet");
    }

    @Override
    public boolean canProvide(String resourceName) {
        return resourceName.endsWith(".mesh");
    }
}
