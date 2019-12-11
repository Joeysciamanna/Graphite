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
//import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.io.Closeable;
//import java.nio.FloatBuffer;
//import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Set;

//import org.joml.Vector3f;
//import org.lwjgl.system.MemoryUtil;

public class VAO implements Closeable {

	private int id;
	private Set<VBO> vbos;
	
	public VAO() {
		vbos = new HashSet<>();
		id = glGenVertexArrays();
	}
	
	public void add(VBO vbo) {
		glBindVertexArray(id);
		for (VBO v : vbos) {
			if(v.getType() == vbo.getType()) {
				throw new IllegalArgumentException(vbo.getType() + " Alredy exist on VAO");
			}
		}
		vbo.doInit(this);
		glBindVertexArray(0);
		vbos.add(vbo);
	}
	
	

	@Override
	public void close() {
		glDisableVertexAttribArray(id);

		// Delete the VBOs
//		glBindBuffer(GL_ARRAY_BUFFER, 0);
		vbos.forEach((vbo)->vbo.close());

		// Delete the VAO
		glBindVertexArray(0);
		glDeleteVertexArrays(id);
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
