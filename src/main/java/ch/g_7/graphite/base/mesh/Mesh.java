package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.mesh.vao.IVBOType;
import ch.g_7.graphite.base.mesh.vao.VAO;
import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.mesh.vao.VBOFactory;
import ch.g_7.graphite.base.mesh.vao.VBOType;
import ch.g_7.graphite.resource.IResource;
import ch.g_7.graphite.resource.IResourceKey;

public class Mesh implements IMesh, IResource, IResourceKey {

	public final static String NAME = "MESH";
	
	private final static IVBOType[] DEFAULT_SUPPORTED_VBOS = new IVBOType[]{VBOType.POSITIONS, VBOType.INDICES, VBOType.TEXTURE_COORDINATES};

	private VAO vao;
	private int verticesCount;

	public Mesh(float[] positions, int[] indices, IVBOType[] supportedVBOs) {
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

	@Override
	public String getResourceName() {
		return NAME;
	}

}
