package ch.g_7.graphite.base.mesh;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.lwjgl.system.MemoryUtil;

public abstract class Mesh implements AutoCloseable {

	private int vaoId;
	private final List<Integer> vboIdList;
	private int vertexCount;

	private List<Vector3fc> points;
	private List<Vector3fc> normals;

	
	public Mesh() {
		vboIdList = new ArrayList<Integer>();
		vaoId = glGenVertexArrays();
		points = new ArrayList<>();
		normals = new ArrayList<>();
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public int getVaoId() {
		return vaoId;
	}

	public List<Integer> getVboIdList() {
		return vboIdList;
	}

	
	protected void setTextureCoordinates(float[] textCoords) {
		FloatBuffer textCoordsBuffer = null;
		try {
			glBindVertexArray(vaoId);

			// Texture coordinates VBO
			int vboId = glGenBuffers();
			vboIdList.add(vboId);
			textCoordsBuffer = MemoryUtil.memAllocFloat(textCoords.length);
			textCoordsBuffer.put(textCoords).flip();
			glBindBuffer(GL_ARRAY_BUFFER, vboId);
			glBufferData(GL_ARRAY_BUFFER, textCoordsBuffer, GL_STATIC_DRAW);
			glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);

			glBindBuffer(GL_ARRAY_BUFFER, 0);
			glBindVertexArray(0);
		} finally {
			if (textCoordsBuffer != null) {
				MemoryUtil.memFree(textCoordsBuffer);
			}
		}
	}
	
	public void setNormals(List<Vector3fc> normals) {
		this.normals = normals;
	}

	protected void setVertices(float[] positions, int[] indices) {
		FloatBuffer posBuffer = null;
		IntBuffer indicesBuffer = null;
		try {
			vertexCount = indices.length;

			vaoId = glGenVertexArrays();
			glBindVertexArray(vaoId);

			// Position VBO
			int vboId = glGenBuffers();
			vboIdList.add(vboId);
			posBuffer = MemoryUtil.memAllocFloat(positions.length);
			posBuffer.put(positions).flip();
			glBindBuffer(GL_ARRAY_BUFFER, vboId);
			glBufferData(GL_ARRAY_BUFFER, posBuffer, GL_STATIC_DRAW);
			glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

			// Index VBO
			vboId = glGenBuffers();
			vboIdList.add(vboId);
			indicesBuffer = MemoryUtil.memAllocInt(indices.length);
			indicesBuffer.put(indices).flip();
			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboId);
			glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);

			glBindBuffer(GL_ARRAY_BUFFER, 0);
			glBindVertexArray(0);
		} finally {
			if (posBuffer != null) {
				MemoryUtil.memFree(posBuffer);
			}
			if (indicesBuffer != null) {
				MemoryUtil.memFree(indicesBuffer);
			}
		}
		for (int i = 0; i < positions.length; i+=3) {
			this.points.add(new Vector3f(positions[i], positions[i+1], positions[i+2]));
		}
		
	}

	public void close() {
		glDisableVertexAttribArray(0);

		// Delete the VBOs
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		for (int vboId : vboIdList) {
			glDeleteBuffers(vboId);
		}

		// Delete the VAO
		glBindVertexArray(0);
		glDeleteVertexArrays(vaoId);
	}
	
	public List<Vector3fc> getNormals() {
		return normals;
	}
	
	public List<Vector3fc> getPoints() {
		return points;
	}
}
