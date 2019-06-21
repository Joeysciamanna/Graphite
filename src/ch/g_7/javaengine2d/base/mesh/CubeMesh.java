package ch.g_7.javaengine2d.base.mesh;

public class CubeMesh extends AbstractMesh{

	public CubeMesh(float sideLength) {
		setVertices(new float[] {     
	            -sideLength/2, sideLength/2, sideLength/2,
	            -sideLength/2, -sideLength/2, sideLength/2,
	            sideLength/2, -sideLength/2, sideLength/2,
	            sideLength/2, sideLength/2, sideLength/2,
	            -sideLength/2, sideLength/2, -sideLength/2,
	            sideLength/2, sideLength/2, -sideLength/2,
	            -sideLength/2, -sideLength/2, -sideLength/2,
	            sideLength/2, -sideLength/2, -sideLength/2,
	            -sideLength/2, sideLength/2, -sideLength/2,
	            sideLength/2, sideLength/2, -sideLength/2,
	            -sideLength/2, sideLength/2, sideLength/2,
	            sideLength/2, sideLength/2, sideLength/2,
	            sideLength/2, sideLength/2, sideLength/2,
	            sideLength/2, -sideLength/2, sideLength/2,
	            -sideLength/2, sideLength/2, sideLength/2,
	            -sideLength/2, -sideLength/2, sideLength/2,
	            -sideLength/2, -sideLength/2, -sideLength/2,
	            sideLength/2, -sideLength/2, -sideLength/2,
	            -sideLength/2, -sideLength/2, sideLength/2,
	            sideLength/2, -sideLength/2, sideLength/2 },
				new int[] {
			    0, 1, 3, 3, 1, 2,
			    8, 10, 11, 9, 8, 11,
			    12, 13, 7, 5, 12, 7,
			    14, 15, 6, 4, 14, 6,
			    16, 18, 19, 17, 16, 19,
			    4, 6, 7, 5, 4, 7}
				);
		
		setTextureCoordinates(new float[] {
				  0.0f, 0.0f,
		            0.0f, 1,
		            1, 1,
		            1, 0.0f,
		            0.0f, 0.0f,
		            1, 0.0f,
		            0.0f, 1,
		            1, 1,
		            
		            0.0f, 1,
		            1, 1,
		            0.0f, 1.0f,
		            1, 1.0f,
		            
		            0.0f, 0.0f,
		            0.0f, 1,
		            
		            1, 0.0f,
		            1, 1,
		            
		            1, 0.0f,
		            1.0f, 0.0f,
		            1, 1,
		            1.0f, 1});
		

	}
}
