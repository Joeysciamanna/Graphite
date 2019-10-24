package ch.g_7.graphite.entity.mesh;

public class MeshFactory {

	
	public static MeshBuilder getRegular(int corners, float side) {
		MeshBuilder builder = new MeshBuilder();
		for(int i = 0; i<corners-1; i++) {
			builder.forward(side);
			builder.turn((corners-2)*180/corners-180);
		}
		return builder;
	}
	
	public static MeshBuilder getSquare(float side) {
		return getRegular(4, side);
	}
	
	public static MeshBuilder getRectangle(float side1, float side2) {
		MeshBuilder builder = new MeshBuilder();
		builder.forward(side1).turn(90).forward(side2).turn(90).forward(side1);
		return builder;
	}
	

	
}
