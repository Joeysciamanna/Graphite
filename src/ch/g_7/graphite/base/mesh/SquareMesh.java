package ch.g_7.graphite.base.mesh;

public class SquareMesh extends AbstractMesh{
	

	public SquareMesh(float sideLength) {
		setVertices(new float[] {     
				-sideLength/2,  sideLength/2, 0.0f,
		        -sideLength/2, -sideLength/2, 0.0f,
		        sideLength/2, -sideLength/2, 0.0f,
		        sideLength/2, sideLength/2, 0.0f}, 
				new int[] {
				 0, 1, 3, 3, 1, 2,	
				});
		setTextureCoordinates(new float[] {
				0,0,
		        0,1,
		        1,1,
		        1,0
		         });
	}
	


}
