package ch.g_7.graphite.base.vao;

import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;

import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;

public class PositionVBO extends FloatVBO {

	private int[] indices;
	private IndicesVBO indicesVBO;
	
	protected PositionVBO(float[] positions, int[] indices) {
		super(VBOType.POSITIONS, positions);
		this.indices = indices;
	}

	@Override
	protected void doInit(VAO vao) {
		super.doInit(vao);
		indicesVBO = new IndicesVBO(indices);
		vao.add(indicesVBO);
		indices = null;
	}
	
	@Override
	protected void doClose() {
		indicesVBO.close();
		super.close();
	}
	
	private static class IndicesVBO extends IntVBO {

		private IndicesVBO(int[] ints) {
			super(VBOType.INDICES, ints);
		}
		
		@Override
		protected void doInit(VAO vao) {
			IntBuffer indicesBuffer = MemoryUtil.memAllocInt(ints.length);
			indicesBuffer.put(ints).flip();
			glBindBuffer(type.glBufferTarget, getId());
			glBufferData(type.glBufferTarget, indicesBuffer, GL_STATIC_DRAW);
			MemoryUtil.memFree(indicesBuffer);
			ints = null;
		}
	}
	
}
