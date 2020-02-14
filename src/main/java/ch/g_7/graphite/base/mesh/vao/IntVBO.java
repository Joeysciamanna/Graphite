package ch.g_7.graphite.base.mesh.vao;

import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

import java.nio.IntBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class IntVBO extends VBO {

	protected int[] ints;
	
	protected IntVBO(VBOType type, int[] ints) {
		super(type);
		this.ints = ints;
		if(type.glNumber != GL11.GL_INT) {
			throw new IllegalArgumentException("VBOType " + type.toString() + " is not for int");
		}
	}

	@Override
	protected void allocate() {
		IntBuffer indicesBuffer = MemoryUtil.memAllocInt(ints.length);
		indicesBuffer.put(ints).flip();
		glBindBuffer(type.glBufferTarget, getId());
		glBufferData(type.glBufferTarget, indicesBuffer, GL_STATIC_DRAW);
		glVertexAttribPointer(type.position, type.size, type.glNumber, false, 0, 0);
		MemoryUtil.memFree(indicesBuffer);
		ints = null;
	}


}
