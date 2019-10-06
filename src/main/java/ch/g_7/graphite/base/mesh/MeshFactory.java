package ch.g_7.graphite.base.mesh;

public class MeshFactory {

	
	public static Mesh getRegular(int corners, int side) {
		MeshBuilder builder = new MeshBuilder();
		for(int i = 0; i<corners; i++) {
			builder.addLine(side,Math.toRadians((corners-2)*180/corners));
		}
		return builder.build();
	}
}
