package ch.g_7.graphite.base.mesh.vao;

import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

public class FloatVBO extends VBO {
	
	protected float[] floats;
	
	public FloatVBO(IVBOType type, float[] floats) {
		super(type);
		this.floats = floats;
		if(type.getGlNumber() != GL11.GL_FLOAT) {
			throw new IllegalArgumentException("VBOType " + type + " is not for float");
		}
	}

	@Override
	protected void allocate(VAO vao) {
		FloatBuffer indicesBuffer = MemoryUtil.memAllocFloat(floats.length);
		indicesBuffer.put(floats).flip();
		glBindBuffer(type.getGlBufferTarget(), getId());
		glBufferData(type.getGlBufferTarget(), indicesBuffer, GL_STATIC_DRAW);
		glVertexAttribPointer(vao.getPositionFor(type), type.getSize(), type.getGlNumber() , false, 0, 0);
		MemoryUtil.memFree(indicesBuffer);
	}


}