package ch.g_7.graphite.base.vao;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;

import java.io.Closeable;

import ch.g_7.util.resource.Resource;


public abstract class VBO extends Resource implements Closeable {
	
	protected final VBOType type;
	
	private VAO vao;
	private int id;

	protected VBO(VBOType type) {
		this.type = type;
	}

	@Override
	protected void doInit() {
		this.id =  glGenBuffers();
		doInit(vao);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
	protected abstract void doInit(VAO vao);
	
	@Override
	protected void doClose() {
		glDeleteBuffers(id);
	}
	
	public void setVao(VAO vao) {
		if(this.vao != null) {
			throw new IllegalStateException("VAO alredy set, cant change vao of vbo");
		}
		this.vao = vao;
	}

	public VBOType getType() {
		return type;
	}
	
	public int getId() {
		return id;
	}
	
}
