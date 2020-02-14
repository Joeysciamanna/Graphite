package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.BasicResourceProvider;

public class MeshProvider extends BasicResourceProvider<Mesh> {



    @Override
    protected Mesh loadResource(String resourceName) throws IllegalArgumentException {
        return null;
    }

    @Override
    public boolean canProvide(String resourceName) {
        return false;
    }
}
