package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.mesh.vao.*;
import ch.g_7.graphite.resource.IResource;

public class Mesh implements IMesh, IResource {

	private final static IVBOType[] DEFAULT_SUPPORTED_VBOS = new IVBOType[]{VBOType.POSITIONS, VBOType.INDICES, VBOType.TEXTURE_COORDINATES};

	private VAO vao;
	private int verticesCount;

	Mesh(float[] positions, int[] indices, IVBOType[] supportedVBOs) {
		if (indices.length % 2 != 0 && indices.length % 3 != 0)
			throw new IllegalArgumentException("Invalid number of indices for 2d/3d mesh");
		this.vao = new VAO(supportedVBOs);
		this.vao.add(VBOFactory.getPositionVBO(positions, indices));
		this.verticesCount = indices.length;
	}

	Mesh(float[] positions, int[] indices) {
		this(positions, indices, DEFAULT_SUPPORTED_VBOS);
	}

	
	public void add(VBO vbo) {
		this.vao.add(vbo);
	}
	
	@Override
	public int getVerticesCount() {
		return verticesCount;
	}

	@Override
	public void bind() {
		vao.bind();
	}

	@Override
	public void unbind() {
		vao.unbind();
	}

	@Override
	public void init() {}

	@Override
	public void close() {
		vao.close();
	}

}
