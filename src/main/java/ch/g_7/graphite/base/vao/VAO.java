package ch.g_7.graphite.base.vao;

//import static org.lwjgl.opengl.GL11.GL_FLOAT;
//import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
//import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
//import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
//import static org.lwjgl.opengl.GL15.glBindBuffer;
//import static org.lwjgl.opengl.GL15.glBufferData;
//import static org.lwjgl.opengl.GL15.glDeleteBuffers;
//import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
//import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.io.Closeable;
//import java.nio.FloatBuffer;
//import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.lwjgl.opengl.GL20;

import ch.g_7.util.stuff.Initializable;

//import org.joml.Vector3f;
//import org.lwjgl.system.MemoryUtil;

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
	
	
//	void setTextureCoordinates(float[] textCoords) {
//
//		glBindVertexArray(vaoId);
//
//		// Texture coordinates VBO
//		int vboId = glGenBuffers();
//		vboIdList.add(vboId);
//		FloatBuffer textCoordsBuffer = MemoryUtil.memAllocFloat(textCoords.length);
//		textCoordsBuffer.put(textCoords).flip();
//		glBindBuffer(GL_ARRAY_BUFFER, vboId);
//		glBufferData(GL_ARRAY_BUFFER, textCoordsBuffer, GL_STATIC_DRAW);
//		glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);
//
//		glBindBuffer(GL_ARRAY_BUFFER, 0);
//		glBindVertexArray(0);
//
//		MemoryUtil.memFree(textCoordsBuffer);
//
//	}
//
//	protected void setVertices(float[] positions, int[] indices) {
//
//		vertexCount = indices.length;
//
//		vaoId = glGenVertexArrays();
//		glBindVertexArray(vaoId);
//
//		// Position VBO
//		int vboId = glGenBuffers();
//		vboIdList.add(vboId);
//		FloatBuffer posBuffer = MemoryUtil.memAllocFloat(positions.length);
//		posBuffer.put(positions).flip();
//		glBindBuffer(GL_ARRAY_BUFFER, vboId);
//		glBufferData(GL_ARRAY_BUFFER, posBuffer, GL_STATIC_DRAW);
//		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
//
//		// Index VBO
//		vboId = glGenBuffers();
//		vboIdList.add(vboId);
//		IntBuffer indicesBuffer = MemoryUtil.memAllocInt(indices.length);
//		indicesBuffer.put(indices).flip();
//		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboId);
//		glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
//
//		glBindBuffer(GL_ARRAY_BUFFER, 0);
//		glBindVertexArray(0);
//
//		MemoryUtil.memFree(posBuffer);
//
//		MemoryUtil.memFree(indicesBuffer);
//
//		for (int i = 0; i < positions.length; i += 3) {
//			this.getPoints().add(new Vector3f(positions[i], positions[i + 1], positions[i + 2]));
//		}
//
//	}
//	
//	public void close() {
//		glDisableVertexAttribArray(0);
//
//		// Delete the VBOs
//		glBindBuffer(GL_ARRAY_BUFFER, 0);
//		for (int vboId : vboIdList) {
//			glDeleteBuffers(vboId);
//		}
//
//		// Delete the VAO
//		glBindVertexArray(0);
//		glDeleteVertexArrays(vaoId);
//	}
}
