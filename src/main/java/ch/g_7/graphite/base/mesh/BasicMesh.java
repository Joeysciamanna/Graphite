package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.graphite.base.vao.VBOFactory;
import ch.g_7.graphite.base.vao.VBOType;

public abstract class BasicMesh implements IMesh {

	protected final VAO vao;
	
	private float[] positions;
	private int[] indices;
	private float[] textureCoordinates;
	private int verticesCount;
	
	public BasicMesh(float[] positions, int[] indices, float[] textureCoordinates) {
		this.vao = new VAO();
		this.positions = positions;
		this.indices = indices;
		this.textureCoordinates = textureCoordinates;
		this.verticesCount = indices.length;
	}


	@Override
	public void init() {
		vao.init();
		vao.add(VBOFactory.getPositionVBO(getPositionVBOType(),positions, indices));
		if(textureCoordinates != null) {
			vao.add(VBOFactory.getTextureCoordinatesVBO(textureCoordinates));
		}
		this.positions = null;
		this.indices = null;
		this.textureCoordinates = null;
	}
	
	protected abstract VBOType getPositionVBOType();

	@Override
	public int getVerticesCount() {
		return verticesCount;
	}

	@Override
	public VAO getVAO() {
		return vao;
	}

	@Override
	public void close() {
		vao.close();
	}
}
