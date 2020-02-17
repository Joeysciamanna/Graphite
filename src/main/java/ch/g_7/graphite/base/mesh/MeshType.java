package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.IResourceKey;

public enum MeshType implements IMeshKey {
    SQUARE, TRIANGLE;

    public final static String NAME = "MESH_TYPE";

    @Override
    public String getResourceName() {
        return NAME;
    }
}
