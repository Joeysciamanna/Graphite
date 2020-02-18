package ch.g_7.graphite.base.mesh.vao;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

public enum VBOType implements IVBOType {

	POSITIONS(GL15.GL_ARRAY_BUFFER, 3, GL11.GL_FLOAT),
	INDICES(GL15.GL_ELEMENT_ARRAY_BUFFER, -1, GL11.GL_INT),
	TEXTURE_COORDINATES(GL15.GL_ARRAY_BUFFER, 2, GL11.GL_FLOAT);

	private final int glBufferTarget;
	private final int size;
	private final int glNumber;
	
	VBOType(int glType, int size, int number) {
		this.glBufferTarget = glType;
		this.size = size;
		this.glNumber = number;
	}

	@Override
	public String getName() {
		return toString();
	}

	@Override
	public int getGlBufferTarget() {
		return glBufferTarget;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int getGlNumber() {
		return glNumber;
	}

}
