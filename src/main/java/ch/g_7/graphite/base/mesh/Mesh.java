package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.graphite.base.vao.VBOFactory;
import ch.g_7.util.resource.IDepender;
import ch.g_7.util.resource.Resource;

public class Mesh extends Resource implements IMesh, IDepender {

	protected final VAO vao;

	private float[] positions;
	private int[] indices;
	private float[] textureCoordinates;
	private int verticesCount;

	public Mesh(float[] positions, int[] indices, float[] textureCoordinates) {
		if (indices.length % 2 != 0 && indices.length % 3 != 0)
			throw new IllegalArgumentException("Invalid number of indices for 2d/3d mesh");
		this.vao = new VAO();
		this.positions = positions;
		this.indices = indices;
		this.textureCoordinates = textureCoordinates;
		this.verticesCount = indices.length;
	}

	public Mesh(float[] positions, int[] indices) {
		this(positions, indices, null);
	}

	@Override
	protected void doInit() {
		vao.bind(this);
		vao.add(VBOFactory.getPositionVBO(positions, indices));
		if (textureCoordinates != null) {
			vao.add(VBOFactory.getTextureCoordinatesVBO(textureCoordinates));
		}
		this.positions = null;
		this.indices = null;
		this.textureCoordinates = null;
	}

	@Override
	protected void doClose() {
		vao.unbind(this);
	}

	public void setPositions(float[] positions, int[] indices) {
		vao.replace(VBOFactory.getPositionVBO(positions, indices));
	}
	
	@Override
	public void setTextureCoordinates(float[] textureCoordinates) {
		vao.replace(VBOFactory.getTextureCoordinatesVBO(textureCoordinates));
	}
	
	@Override
	public int getVerticesCount() {
		return verticesCount;
	}

	@Override
	public VAO getVAO() {
		return vao;
	}

}
