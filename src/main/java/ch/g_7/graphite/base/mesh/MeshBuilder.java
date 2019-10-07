package ch.g_7.graphite.base.mesh;

import java.util.ArrayList;
import java.util.List;

import org.joml.Rectangled;
import org.joml.Vector2d;

public class MeshBuilder {

	private List<Vector2d> points;
	int angle = 90;
	
	public MeshBuilder() {
		points = new ArrayList<>();
		points.add(new Vector2d(0, 0));
	}
	
	public MeshBuilder setAngle(int angle) {
		this.angle = angle;
		return this;
	}
	
	public MeshBuilder turn(int angle) {
		this.angle += angle;
		return this;
	}

	public MeshBuilder forward(double distance) {
		Vector2d lastPos = points.get(points.size() - 1);
		double x = lastPos.x + (Math.sin(Math.toRadians(angle)) * distance);
		double y = lastPos.y + (Math.cos(Math.toRadians(angle)) * distance);
		points.add(new Vector2d(x, y));
		return this;
	}

	public MeshBuilder goTo(Vector2d toPos) {
		points.add(toPos);
		return this;
	}
	
	
	public MeshBuilder center() {
		setCenter(new Vector2d(getWidth()/2,getHeight()/2));
		return this;
	}
	
	public MeshBuilder centerTopLeft() {
		setCenter(new Vector2d(getBounds().minX, getBounds().maxY));
		return this;
	}

	public MeshBuilder setCenter(Vector2d point) {
		for (Vector2d p : points) {
			p.set(p.x  - point.x, p.y - point.y);
		}
		return this;
	} 
	
	public double getWidth() {
		Rectangled rectangle = getBounds();
		return rectangle.maxX - rectangle.minX;
	}
	
	
	public double getHeight() {
		Rectangled rectangle = getBounds();
		return rectangle.maxY - rectangle.minY;
	}
	

	public Rectangled getBounds() {
		double maxX = 0;
		double minX = Integer.MAX_VALUE;
		double maxY = 0;
		double minY = Integer.MAX_VALUE;
		
		for (Vector2d point : points) {
			maxX = point.x > maxX ? point.x : maxX;
			minX = point.x < minX ? point.x : minX;
			
			maxY = point.y > maxY ? point.y : maxY;
			minY = point.y < minY ? point.y : minY;
		}
		
		return new Rectangled(minX, minY, maxX, maxY);
	}
	
	
	
	public Mesh build() {
		float[] positions = new float[points.size() * 3];
		for (int i = 0; i < points.size(); i++) {
			positions[i * 3 + 0] = (float) points.get(i).x;
			positions[i * 3 + 1] = (float) points.get(i).y;
			positions[i * 3 + 2] = 0;
		}
		
		List<Integer> indices = new ArrayList<>(((points.size() - 2) * 3));
		
		int act = 0;
		int step = 2;
		
		for(int i = 2; i<points.size(); i++) {
			int next = fitIndex(act+step, 0, points.size());
			indices.add(act);
			if(i%2==0) {
				indices.add(fitIndex(next-1,0,points.size()));
				indices.add(next);
			} else {
				indices.add(next);
				indices.add(fitIndex(next+1,0,points.size()));
			}			
			step = step > 0 ? step*-1-1 : step*-1+1;
			act = next;
		}

		int[] realIndices = new int[(points.size() - 2) * 3];
		
		for (int j = 0; j < realIndices.length; j++) {
			realIndices[j] = indices.get(j);
		}
		
		return new BasicMesh(positions, realIndices);
	}
	
	

	private int fitIndex(int index, int from, int to) {
		int newIndex = index;
		int range = to - from;
		while (newIndex < from) {
			newIndex = newIndex + range;
		}
		while (newIndex >= to) {
			newIndex = newIndex - range;
		}
		return newIndex;
	}

}


