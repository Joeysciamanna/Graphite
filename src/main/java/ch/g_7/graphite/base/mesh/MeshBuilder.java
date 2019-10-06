package ch.g_7.graphite.base.mesh;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2d;

public class MeshBuilder {

	private List<Vector2d> points;
	private double angle;

	public MeshBuilder() {
		points = new ArrayList<>();
		points.add(new Vector2d(0, 0));
		angle = 0;
	}

	public void addLine(double lenght, double angle) {
		this.angle += angle;
		Vector2d lastPos = points.get(points.size() - 1);
		double x = lastPos.x + (Math.cos(Math.toRadians(this.angle)) * lenght);
		double y = lastPos.y + (Math.sin(Math.toRadians(this.angle)) * lenght);
		points.add(new Vector2d(x, y));
//		System.out.println(x + "|" + y + "\t: " + lastPos.x + "|" + lastPos.y + " - ");
	}

	public void addLine(Vector2d toPos) {
		points.add(toPos);
	}

	public Mesh build() {
		float[] positions = new float[points.size() * 3];
//		int[] indices = new int[(points.size()-2)*3];
		for (int i = 0; i < points.size(); i++) {
			positions[i * 3 + 0] = (float) points.get(i).x;
			positions[i * 3 + 1] = (float) points.get(i).y;
			positions[i * 3 + 2] = 0;
			System.out.println(positions[i* 3] + "|" + positions[i* 3 + 1] + "|" + positions[i* 3 + 2]);
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
		for (int i = 0; i < points.size() - 2; i++) {
			int next = act + step;
			step = step > 0 ? step * -1 - 1 : step * -1 + 1;
			indices.add(fitIndex(act, 0, points.size()));
			indices.add(fitIndex(next, 0, points.size()));
			indices.add(fitIndex(next - 1, 0, points.size()));
			act = next;
		}

		System.out.println(((points.size() - 2) * 3) + " : " + indices.size());

		int[] realIndices = new int[(points.size() - 2) * 3];
		for (int j = 0; j < realIndices.length; j++) {
			realIndices[j] = indices.get(j);

		}
		return new BasicMesh(positions, realIndices);
	}

	private int fitIndex(int index, int from, int to) {
		int range = to - from;
		while (index < from) {
			index = index + range;
		}
		while (index > to) {
			index = index - range;
		}
		return index;
	}

}
