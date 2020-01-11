package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.graphite.base.vao.VBOFactory;
import ch.g_7.graphite.util.ResourceHandler;

public class Mesh implements IMesh {

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
	public final void init() {
		if (ResourceHandler.shallInitialize(this))
			doInit();
	}

	protected void doInit() {
		vao.init();
		vao.add(VBOFactory.getPositionVBO(positions, indices));
		if (textureCoordinates != null) {
			vao.add(VBOFactory.getTextureCoordinatesVBO(textureCoordinates));
		}
		this.positions = null;
		this.indices = null;
		this.textureCoordinates = null;

	}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallInitialize(this)) doClose();
	}

	protected void doClose() {
		vao.close();
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
