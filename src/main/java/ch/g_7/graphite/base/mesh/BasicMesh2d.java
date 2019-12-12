package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.vao.VBOFactory;

public class BasicMesh2d extends AbstractMesh implements IMesh2d {

	private float[] positions;
	private int[] indices;
	private float[] textureCoordinates;
	private int verticesCount;
	
	public BasicMesh2d(float[] positions, int[] indices) {
		this(positions, indices, null);
	}
	
	public BasicMesh2d(float[] positions, int[] indices, float[] textureCoordinates) {
		if(indices.length % 2 != 0) throw new IllegalArgumentException("Invalid number of indices for 2d mesh");
		this.positions = positions;
		this.indices = indices;
		this.textureCoordinates = textureCoordinates;
		this.verticesCount = indices.length;
	}
	

	@Override
	public void init() {
		super.init();
		vao.add(VBOFactory.getPosition2dVBO(positions, indices));
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
