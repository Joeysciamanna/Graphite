package ch.g_7.graphite.base.mesh;

public class BasicMesh extends Mesh {

	
	public BasicMesh(float[] positions, int[] indices) {
		setVertices(positions, indices);
		setTextureCoordinates(new float[] {
				0,0,
		        0,0,
		        0,0,
		        0,0,
		        0,0,
		        0,0,
		        0,0,
		        0,0,
		         });
	}

	
}
