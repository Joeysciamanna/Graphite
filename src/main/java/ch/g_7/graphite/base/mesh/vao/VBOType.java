package ch.g_7.graphite.base.mesh.vao;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

@Deprecated
public enum VBOType {

	POSITIONS(GL15.GL_ARRAY_BUFFER, 3, GL11.GL_FLOAT, 0),
	INDICES(GL15.GL_ELEMENT_ARRAY_BUFFER, -1, GL11.GL_INT, 1),
	TEXTURE_COORDINATES(GL15.GL_ARRAY_BUFFER, 2, GL11.GL_FLOAT, 2);
	
	
	public final int glBufferTarget;
	public final int size;
	public final int glNumber;
	public final int position;
	
	VBOType(int glType, int size, int number, int position) {
		this.glBufferTarget = glType;
		this.size = size;
		this.glNumber = number;
		this.position = position;
	}

	
}
