package ch.g_7.graphite.base.vao;

public final class VBOFactory {

	private  VBOFactory() {}
	
	
	public static VBO getPosition2dVBO(float[] positions, int[] indices) {
		return new PositionVBO(VBOType.POSITIONS_2D, positions, indices);
	}
	
	public static VBO getPosition3dVBO(float[] positions, int[] indices) {
		return new PositionVBO(VBOType.POSITIONS_3D, positions, indices);
	}
	
	public static VBO getTextureCoordinatesVBO(float[] coordinates) {
		return new FloatVBO(VBOType.TEXTURE_COORDINATES, coordinates);
	}
	
}
