package ch.g_7.graphite.base.mesh.vao;

import ch.g_7.util.common.Closeable;

import static org.lwjgl.opengl.GL15.*;


public abstract class VBO implements Closeable {
	
	protected final IVBOType type;
	private int id = -1;

	VBO(IVBOType type) {
		this.type = type;
	}

	protected final void init(VAO vao){
		if(id != -1);
			this.id = glGenBuffers();
		allocate(vao);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}

	protected abstract void allocate(VAO vao);

	@Override
	public void close() {
		glDeleteBuffers(id);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return type.getName();
	}
}
