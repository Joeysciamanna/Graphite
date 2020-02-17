package ch.g_7.graphite.base.mesh;

@Deprecated
public final class MeshFactory2d {

	
	public static MeshKeyBuilder2d getRegular(int corners, float side) {
		MeshKeyBuilder2d builder = new MeshKeyBuilder2d();
		for(int i = 0; i<corners-1; i++) {
			builder.forward(side);
			builder.turn((corners-2)*180/corners-180);
		}
		return builder;
	}
	
	public static MeshKeyBuilder2d getSquare(float side) {
		return getRegular(4, side);
	}
	
	public static MeshKeyBuilder2d getRectangle(float side1, float side2) {
		MeshKeyBuilder2d builder = new MeshKeyBuilder2d();
		builder.forward(side1).turn(90).forward(side2).turn(90).forward(side1);
		return builder;
	}
	

	
}
