package ch.g_7.graphite.base.mesh.vao;

import ch.g_7.graphite.resource.IResource;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;


public abstract class VBO implements Closeable {
	
	protected final VBOType type;

	private int id = -1;

	VBO(VBOType type) {
		this.type = type;

	}

	protected final void init(VAO vao){
		if(id != -1) throw new IllegalStateException("Cant move VBO, VBO already initialized");
		this.id = glGenBuffers();
		doInit(vao);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}

	protected abstract void doInit(VAO vao);

	@Override
	public void close() {
		glDeleteBuffers(id);
	}

	public VBOType getType() {
		return type;
	}
	
	public int getId() {
		return id;
	}
	
}
