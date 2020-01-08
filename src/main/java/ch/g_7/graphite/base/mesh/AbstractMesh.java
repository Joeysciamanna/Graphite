package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.vao.VAO;

public abstract class AbstractMesh implements IMesh {

	protected final VAO vao;
	
	protected AbstractMesh() {
		this.vao = new VAO();
	}
	
	@Override
	public void init() {
		vao.init();
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
