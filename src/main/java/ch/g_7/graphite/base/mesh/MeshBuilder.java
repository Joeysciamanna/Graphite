package ch.g_7.graphite.base.mesh;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2d;

public class MeshBuilder {

	private List<Vector2d> points;

	public MeshBuilder() {
		points = new ArrayList<>();
		points.add(new Vector2d(0, 0));
	}

	public void addLine(double lenght, double radiants) {
		Vector2d lastPos = points.get(points.size() - 1);
		double x = lastPos.x + Math.cos(radiants) * lenght;
		double y = lastPos.y + Math.cos(radiants) * lenght;
		points.add(new Vector2d(x, y));
	}

	public void addLine(Vector2d toPos) {
		points.add(toPos);
	}

	public Mesh build() {
		float[] positions = new float[points.size()*3];
//		int[] indices = new int[(points.size()-2)*3];
		
		for (int i = 0; i < points.size(); i++) {
			positions[i*3+0] = (float) points.get(i).x;
			positions[i*3+1] = (float) points.get(i).y;
			positions[i*3+2] = 0;
		}

		
//		int[] indices = new int[(points.size()-2)*3];
//		for (int i = 0; i < positions.length; i+=3) {
//			Pos2d a = get(i);
//			Pos2d b = get(i+1);
//			Pos2d c = get(i+2);
//			positions[i] = points.get(index)
//		}
		List<Integer> indices = new ArrayList<>();
		
		int act = 0;
		int step = 2;
		for(int i = 0; i<points.size()-3;i++) {
			int next = act + step;
			step = step > 0 ? step*-1-1 : step*-1+1;
			indices.add(act);
			indices.add(next);
			indices.add(next-1);
			act = next;
		}
		
		System.out.println(((points.size()-2)*3 )+" : "+indices.size());

		int[] realIndices = new int[(points.size()-2)*3];
		for (int j = 0; j < realIndices.length; j++) {
			realIndices[j] = indices.get(j);
			
		}
		return new BasicMesh(positions, realIndices);
	}
	
	
}
