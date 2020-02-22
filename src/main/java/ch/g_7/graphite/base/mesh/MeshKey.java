package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.util.helper.Util;

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
    
    @Override
    public boolean equals(Object obj) {
    	return Util.isEqual(this, obj, MeshKey::getPositions, MeshKey::getIndices);
    }
}
