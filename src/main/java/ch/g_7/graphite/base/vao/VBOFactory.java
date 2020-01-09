package ch.g_7.graphite.base.vao;

public final class VBOFactory {

	private  VBOFactory() {}
	
	
	public static VBO getPositionVBO(float[] positions, int[] indices) {
		return new PositionVBO(positions, indices);
	}

	public static VBO getTextureCoordinatesVBO(float[] coordinates) {
		return new FloatVBO(VBOType.TEXTURE_COORDINATES, coordinates);
	}
	
}
