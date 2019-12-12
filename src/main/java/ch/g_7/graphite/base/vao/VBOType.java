package ch.g_7.graphite.base.vao;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

public enum VBOType {

	POSITIONS_2D(GL15.GL_ARRAY_BUFFER, 2, GL11.GL_FLOAT),
	POSITIONS_3D(GL15.GL_ARRAY_BUFFER, 3, GL11.GL_FLOAT),
	INDICES(GL15.GL_ELEMENT_ARRAY_BUFFER, -1, GL11.GL_INT),
	TEXTURE_COORDINATES(GL15.GL_ARRAY_BUFFER, 2, GL11.GL_FLOAT);
	
	
	public final int glBufferTarget;
	public final int size;
	public final int glNumber;
	
	VBOType(int glType, int size, int number) {
		this.glBufferTarget = glType;
		this.size = size;
		this.glNumber = number;
	}

	
}
