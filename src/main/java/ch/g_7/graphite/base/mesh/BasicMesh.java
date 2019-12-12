package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.vao.VBOFactory;

public class BasicMesh extends AbstractMesh {

	public static final int DIMENSION_2D = 2;
	public static final int DIMENSION_3D = 2;
	
	private float[] positions;
	private int[] indices;
	private float[] textureCoordinates;
	private int verticesCount;
	private int dimension;
	
	public BasicMesh(float[] positions, int[] indices, int dimension) {
		this(positions, indices, null, dimension);
	}
	
	public BasicMesh(float[] positions, int[] indices, float[] textureCoordinates, int dimension) {
		this.positions = positions;
		this.indices = indices;
		this.textureCoordinates = textureCoordinates;
		this.verticesCount = indices.length;
		this.dimension = dimension;
	}
	

	@Override
	public void init() {
		super.init();
		if(dimension == DIMENSION_2D) {
			if(indices.length % 2 != 0) throw new IllegalArgumentException("Invalid number of indices for 2d mesh");
			vao.add(VBOFactory.getPosition2dVBO(positions, indices));
		}else if(dimension == DIMENSION_3D){
			if(indices .length % 3 != 0) throw new IllegalArgumentException("Invalid number of indices for 3d mesh");
			vao.add(VBOFactory.getPosition3dVBO(positions, indices));
		}
		
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
