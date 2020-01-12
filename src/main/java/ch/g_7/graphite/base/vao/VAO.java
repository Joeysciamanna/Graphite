package ch.g_7.graphite.base.vao;



import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.lwjgl.opengl.GL20;

import ch.g_7.graphite.util.ResourceHandler;
import ch.g_7.util.able.Initializable;


public class VAO implements AutoCloseable, Initializable {

	private int id;
	private List<VBO> vbos;
	
	private boolean adding;
	private Queue<VBO> addables;
	
	public VAO() {
		this.vbos = new ArrayList<>(3);
		this.addables = new LinkedList<>();
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
	
	
	public void replace(VBO vbo) {
		int index = -1;
		for (int i = 0; i < vbos.size(); i++) {
			if(vbos.get(i).type == vbo.type) {
				index = i;
			}
		}
		if(index == -1) {
			throw new IllegalArgumentException(vbo.type + " Cant be replaced, because it doesnt exist");
		}
		
		vbos.get(index).close();
		
		glBindVertexArray(id);
		vbo.init(this);
		glBindVertexArray(0);
		vbos.set(index, vbo);
	}
	
	private void add(VBO vbo, boolean addAdables) {
		for (VBO v : vbos) {
			if(v.getType().equals(vbo.type)) {
				throw new IllegalArgumentException(vbo.type + " Alredy exist on VAO");
			}
		}
		glBindVertexArray(id);
		vbo.init(this);
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
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}
	
	protected void doInit() {
		id = glGenVertexArrays();
	}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallClose(this)) doClose();
	}
	
	protected void doClose() {

		glDisableVertexAttribArray(id);

		// Delete the VBOs
		GL20.glBindBuffer(GL20.GL_ARRAY_BUFFER, 0);
		vbos.forEach((vbo) -> vbo.close());

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

	

}
