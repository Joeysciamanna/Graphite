package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.vao.VBOFactory;

public class BasicMesh3d extends AbstractMesh implements IMesh3d {
	
	private float[] positions;
	private int[] indices;
	private float[] textureCoordinates;
	private int verticesCount;
	
	public BasicMesh3d(float[] positions, int[] indices) {
		this(positions, indices, null);
	}
	
	public BasicMesh3d(float[] positions, int[] indices, float[] textureCoordinates) {
		if(indices.length % 3 != 0) throw new IllegalArgumentException("Invalid number of indices for 3d mesh");
		this.positions = positions;
		this.indices = indices;
		this.textureCoordinates = textureCoordinates;
		this.verticesCount = indices.length;

	}
	

	@Override
	public void init() {
		super.init();
		vao.add(VBOFactory.getPosition3dVBO(positions, indices));
		if(textureCoordinates != null) {
			vao.add(VBOFactory.getTextureCoordinatesVBO(textureCoordinates));
		}
		this.positions = null;
		this.indices = null;
		this.textureCoordinates = null;
	}


	@Override
	public int getVerticesCount() {
		return verticesCount;
	}
}
