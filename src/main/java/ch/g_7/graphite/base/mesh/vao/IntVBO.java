package ch.g_7.graphite.base.mesh.vao;

import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

public class IntVBO extends VBO {

	protected int[] ints;
	
	protected IntVBO(IVBOType type, int[] ints) {
		super(type);
		this.ints = ints;
		if(type.getGlNumber() != GL11.GL_INT) {
			throw new IllegalArgumentException("VBOType " + type.toString() + " is not for int");
		}
	}

	@Override
	protected void allocate(VAO vao) {
		IntBuffer indicesBuffer = MemoryUtil.memAllocInt(ints.length);
		indicesBuffer.put(ints).flip();
		glBindBuffer(type.getGlBufferTarget(), getId());
		glBufferData(type.getGlBufferTarget(), indicesBuffer, GL_STATIC_DRAW);
		glVertexAttribPointer(vao.getPositionFor(type), type.getSize(), type.getGlNumber(), false, 0, 0);
		MemoryUtil.memFree(indicesBuffer);
	}


}
