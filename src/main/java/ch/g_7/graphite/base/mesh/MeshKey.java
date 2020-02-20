package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.IResourceKey;

import javax.print.attribute.standard.MediaSize;

public class MeshKey implements IResourceKey {

    public final static String NAME = "MESH";

    private float[] positions;
    private int[] indices;

    public MeshKey(float[] positions, int[] indices) {
        this.positions = positions;
        this.indices = indices;
    }

    public float[] getPositions() {
        return positions;
    }

    public int[] getIndices() {
        return indices;
    }

    @Override
    public String getResourceName() {
        return NAME;
    }
}
