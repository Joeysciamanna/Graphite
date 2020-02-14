package ch.g_7.graphite.base.mesh.vao;

import ch.g_7.graphite.resource.IResource;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;


public abstract class VBO implements Initializable, Closeable {
	
	protected final VBOType type;

	private int id;

	protected VBO(VBOType type) {
		this.type = type;

	}

	public final void init(){
		this.id = glGenBuffers();
		doInit();
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}

	protected abstract void doInit();

	public void extinguish() {
		glDeleteBuffers(id);
	}

	public VBOType getType() {
		return type;
	}
	
	public int getId() {
		return id;
	}
	
}
