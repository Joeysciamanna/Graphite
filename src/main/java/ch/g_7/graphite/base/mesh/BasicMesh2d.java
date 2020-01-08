package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.vao.VBOType;

public class BasicMesh2d extends BasicMesh implements IMesh2d {

	public BasicMesh2d(float[] positions, int[] indices, float[] textureCoordinates) {
		super(positions, indices, textureCoordinates);
		if(indices.length % 2 != 0) throw new IllegalArgumentException("Invalid number of indices for 2d mesh");
	}
	
	public BasicMesh2d(float[] positions, int[] indices) {
		this(positions, indices, null);
	}

	@Override
	protected VBOType getPositionVBOType() {
		return VBOType.POSITIONS_2D;
	}


}
