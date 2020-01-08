package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.vao.VBOType;

public class BasicMesh3d extends BasicMesh implements IMesh3d{

	public BasicMesh3d(float[] positions, int[] indices, float[] textureCoordinates) {
		super(positions, indices, textureCoordinates);
		if(indices.length % 3 != 0) throw new IllegalArgumentException("Invalid number of indices for 3d mesh");
	}
	
	public BasicMesh3d(float[] positions, int[] indices) {
		this(positions, indices, null);
	}

	@Override
	protected VBOType getPositionVBOType() {
		return VBOType.POSITIONS_3D;
	}

}
