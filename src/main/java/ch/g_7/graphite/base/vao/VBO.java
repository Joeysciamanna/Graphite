package ch.g_7.graphite.base.vao;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;

import java.io.Closeable;

import ch.g_7.util.resource.ResourceHandler;

public abstract class VBO implements Closeable {
	
	protected final VBOType type;
	private int id;

	protected VBO(VBOType type) {
		this.type = type;
	}
	
	protected final void init(VAO vao) {
		if(ResourceHandler.shallInitialize(this)) {
			this.id =  glGenBuffers();
			doInit(vao);
			glBindBuffer(GL_ARRAY_BUFFER, 0);
		}
	}
	
	protected abstract void doInit(VAO vao);

	public VBOType getType() {
		return type;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallClose(this)) doClose();
	}
	
	protected void doClose() {
		glDeleteBuffers(id);
	}


}
