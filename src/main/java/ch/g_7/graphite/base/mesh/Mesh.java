package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.mesh.vao.PositionVBO;
import ch.g_7.graphite.base.mesh.vao.VAO;
import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.mesh.vao.VBOFactory;

public class Mesh implements IMesh {

	protected VBO positionVBO;

	private int verticesCount;

	public Mesh(float[] positions, int[] indices) {
		if (indices.length % 2 != 0 && indices.length % 3 != 0)
			throw new IllegalArgumentException("Invalid number of indices for 2d/3d mesh");

		this.positionVBO = VBOFactory.getPositionVBO(positions, indices);
		this.verticesCount = indices.length;
	}

	@Override
	public VBO getPositionVBO() {
		return positionVBO;
	}

	@Override
	public int getVerticesCount() {
		return verticesCount;
	}


	@Override
	public void allocate() {
		positionVBO.allocate();
	}

	@Override
	public void extinguish() {
		positionVBO.extinguish();
	}
}
