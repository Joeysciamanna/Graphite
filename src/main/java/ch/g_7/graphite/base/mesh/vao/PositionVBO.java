package ch.g_7.graphite.base.mesh.vao;

import org.lwjgl.system.MemoryUtil;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL15.*;

public class PositionVBO extends FloatVBO {

	private int[] indices;
	private IndicesVBO indicesVBO;
	
	protected PositionVBO(float[] positions, int[] indices) {
		super(VBOType.POSITIONS, positions);
		this.indices = indices;
	}


	@Override
	protected void allocate(VAO vao) {
		super.allocate(vao);
		indicesVBO = new IndicesVBO(indices);
		vao.add(indicesVBO);
	}
	
	private static class IndicesVBO extends IntVBO {

		private IndicesVBO(int[] ints) {
			super(VBOType.INDICES, ints);
		}
		
		@Override
		protected void allocate(VAO vao) {
			IntBuffer indicesBuffer = MemoryUtil.memAllocInt(ints.length);
			indicesBuffer.put(ints).flip();
			glBindBuffer(type.getGlBufferTarget(), getId());
			glBufferData(type.getGlBufferTarget(), indicesBuffer, GL_STATIC_DRAW);
			MemoryUtil.memFree(indicesBuffer);
		}
	}
	
}
