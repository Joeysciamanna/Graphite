package ch.g_7.graphite.base.vao;

import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class FloatVBO extends VBO {
	
	protected float[] floats;
	
	protected FloatVBO(VBOType type, float[] floats) {
		super(type);
		this.floats = floats;
		if(type.glNumber != GL11.GL_FLOAT) {
			throw new IllegalArgumentException("VBOType " + type.toString() + " is not for float");
		}
	}

	@Override
	protected void doInit(VAO vao) {
		FloatBuffer indicesBuffer = MemoryUtil.memAllocFloat(floats.length);
		indicesBuffer.put(floats).flip();
		glBindBuffer(type.glBufferTarget, getId());
		glBufferData(type.glBufferTarget, indicesBuffer, GL_STATIC_DRAW);
		glVertexAttribPointer(type.position, type.size, type.glNumber , false, 0, 0);
		MemoryUtil.memFree(indicesBuffer);
		floats = null;
	}


}