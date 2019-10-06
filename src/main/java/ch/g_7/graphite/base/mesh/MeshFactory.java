package ch.g_7.graphite.base.mesh;

public class MeshFactory {

	
	public static Mesh getRegular(int corners, float side) {
		MeshBuilder builder = new MeshBuilder();
		for(int i = 1; i<corners; i++) {
			builder.addLine(side,(corners-2)*180/corners);
		}
		return builder.build();
	}
}
