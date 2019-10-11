package ch.g_7.graphite.base.mesh;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3fc;

public class BasicMesh extends AbstractMesh {

	private List<Vector3fc> points;
	
	public BasicMesh(float[] positions, int[] indices) {
		points = new ArrayList<>();
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
	
	
	@Override
	public List<Vector3fc> getPoints() {
		return points;
	}

	
}
