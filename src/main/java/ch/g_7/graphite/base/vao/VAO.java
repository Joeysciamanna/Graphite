package ch.g_7.graphite.base.vao;



import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.io.Closeable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.lwjgl.opengl.GL20;

import ch.g_7.util.stuff.Initializable;


public class VAO implements Closeable, Initializable {

	private int id;
	private Set<VBO> vbos;
	
	private boolean adding;
	private Queue<VBO> addables;
	
	public VAO() {
		this.vbos = new HashSet<>();
		this.addables = new LinkedList<>();
	}
	
	@Override
	public void init() {
		id = glGenVertexArrays();
	}
	
	
	public synchronized void add(VBO vbo) {
		if(adding) {
			addables.add(vbo);
			return;
		}
		adding = true;
		
		add(vbo, true);
		
		adding = false;
	}
	
	
	private void add(VBO vbo, boolean addAdables) {
		for (VBO v : vbos) {
			if(v.getType().equals(vbo.type)) {
				throw new IllegalArgumentException(vbo.type + " Alredy exist on VAO");
			}
		}
		glBindVertexArray(id);
		vbo.doInit(this);
		glBindVertexArray(0);
		vbos.add(vbo);
		
		if(addAdables) {
			while(!addables.isEmpty()) {
				add(addables.poll(),false);
			}
		}
	}
	
	public VBO get(VBOType type) {
		for (VBO vbo : vbos) {
			if(vbo.type.equals(type)) return vbo;
		}
		return null;
	}
	
	@Override
	public void close() {
		glDisableVertexAttribArray(id);

		// Delete the VBOs
		GL20.glBindBuffer(GL20.GL_ARRAY_BUFFER, 0);
		vbos.forEach((vbo)->vbo.close());

		// Delete the VAO
		glBindVertexArray(0);
		glDeleteVertexArrays(id);
	}

	public void bind() {
		glBindVertexArray(id);
		for(int i = 0; i < vbos.size(); i++) {
			glEnableVertexAttribArray(i);
		}
	}
	
	public void unbind() {
		glBindVertexArray(0);
		for(int i = 0; i < vbos.size(); i++) {
			glDisableVertexAttribArray(i);
		}
	}
	
	public int nextIndex() {
		return vbos.size();
	}
	

}
