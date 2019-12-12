package ch.g_7.graphite.base.mesh2d;

import ch.g_7.graphite.base.vao.VAO;

public abstract class AbstractMesh implements IMesh {

	protected final VAO vao;
	
	protected AbstractMesh() {
		this.vao = new VAO();
	}
	
	@Override
	public void init() {
		vao.init();
	}

	@Override
	public VAO getVAO() {
		return vao;
	}

	@Override
	public void close() {
		vao.close();
	}

	
	
	
	
	
	

	
	
//	private int vaoId;
//	private final List<Integer> vboIdList;
//	private int vertexCount;
//
//	private Vector3f maxPoint;
//	private Vector3f minPoint;
//	
//	public AbstractMesh() {
//		vboIdList = new ArrayList<Integer>();
//		vaoId = glGenVertexArrays();
//	}
//
//	public int getVertexCount() {
//		return vertexCount;
//	}
//
//	public int getVaoId() {
//		return vaoId;
//	}
//
//	public List<Integer> getVboIdList() {
//		return vboIdList;
//	}
//
//	
//	@Override
//	public Vector3fc getMaxPoint() {
//		if (maxPoint == null) {
//			float maxX = Integer.MIN_VALUE;
//			float maxY = Integer.MIN_VALUE;
//			float maxZ = Integer.MIN_VALUE;
//			for (Vector3fc point : getPoints()) {
//				maxX = point.x() > maxX ? point.x() : maxX;
//				maxY = point.y() > maxY ? point.y() : maxY;
//				maxZ = point.z() > maxZ ? point.z() : maxZ;
//			}
//			maxPoint = new Vector3f(maxX, maxY, maxZ);
//		}
//		return maxPoint;
//	}
//	
//	@Override
//	public Vector3fc getMinPoint() {
//		if (minPoint == null) {
//			float minX = Integer.MAX_VALUE;
//			float minY = Integer.MAX_VALUE;
//			float minZ = Integer.MAX_VALUE;
//			for (Vector3fc point : getPoints()) {
//				minX = point.x() < minX ? point.x() : minX;
//				minY = point.y() < minY ? point.y() : minY;
//				minZ = point.z() < minZ ? point.z() : minZ;
//			}
//			minPoint = new Vector3f(minX, minY, minZ);
//			
//		}
//		return minPoint;
//	}
//
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
//	
//	@Override
//	public void init() {}
}
