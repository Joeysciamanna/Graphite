package ch.g_7.graphite.base.mesh2d;

import ch.g_7.graphite.base.vao.VBOFactory;

public class BasicMesh extends AbstractMesh {

	float[] positions;
	int[] indices;
	float[] textureCoordinates;
	int verticesCount;
	
	public BasicMesh(float[] positions, int[] indices) {
		this(positions, indices, null);
	}
	
	public BasicMesh(float[] positions, int[] indices, float[] textureCoordinates) {
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
