package ch.g_7.graphite.base.vao;

import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;

import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;

public class PositionVBO extends FloatVBO {

	private int[] indices;
	private IndicesVBO indicesVBO;
	
	private PositionVBO(VBOType type, float[] positions, int[] indices) {
		super(type, positions);
		this.indices = indices;
	}

	@Override
	protected void init(VAO vao) {
		super.init(vao);
		indicesVBO = new IndicesVBO(indices);
		vao.add(indicesVBO);
		indices = null;
	}
	
	@Override
	public void close() {
		indicesVBO.close();
		super.close();
	}
	
	
	
	public static PositionVBO get2d(float[] positions, int[] indices) {
		return new PositionVBO(VBOType.POSITIONS_2D, positions, indices);
	}
	
	
	
	public static PositionVBO get3d(float[] positions, int[] indices) {
		return new PositionVBO(VBOType.POSITIONS_3D, positions, indices);
	}
	
	
	
	private static class IndicesVBO extends IntVBO{

		private IndicesVBO(int[] ints) {
			super(VBOType.INDICES, ints);
		}
		
		@Override
		protected void init(VAO vao) {
			IntBuffer indicesBuffer = MemoryUtil.memAllocInt(ints.length);
			indicesBuffer.put(ints).flip();
			glBindBuffer(type.glBufferTarget, getId());
			glBufferData(type.glBufferTarget, indicesBuffer, GL_STATIC_DRAW);
		}
	}
	
}
