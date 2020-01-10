package ch.g_7.graphite.draw;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector3fc;
import org.lwjgl.opengl.GL11;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.draw.object.DrawObject;
import ch.g_7.graphite.draw.object.IDrawObject;
import ch.g_7.graphite.util.Color;

public class DrawContext {

	private List<IDrawObject> drawObjects;
	private DrawObject drawObject;

	
	public DrawContext() {
		this.drawObjects = new ArrayList<>();
		drawObject = new DrawObject();
	}

	public void setBrushColor(Color color) {
		drawObject.setColor(color);
		
	}
	
	public void setBrushTexture(Texture texture) {
		drawObject.setTexture(texture);
	}
	
	public void addLine(Vector3fc from, Vector3fc to) {
		drawObject.setMesh(new Mesh(new float[] {
				from.x(), from.y(), from.z(),
				to.x(), to.y(), to.z()
		}, new int[] {0,1}, new float[] {0,0, 1,1} ));
		drawObject.setGlDrawMethod(GL11.GL_LINES);
		next();
	}
	

	public void addImage(Texture texture, Vector3fc position, Vector2fc size) {
		setBrushTexture(texture);
		addRectangle(position, size);
		next();
	}
	
	public void addRectangle(Vector3fc position, Vector2fc size) {
		drawObject.setMesh(MeshFactory2d.getRectangle(size.x(), size.y()).build());
		drawObject.setPosition(position);
		drawObject.setGlDrawMethod(GL11.GL_TRIANGLES);
		next();
	}

	private void next() {
		if(!drawObject.isEmpty()) {
			drawObject.init();
			add(drawObject);
			drawObject = new DrawObject(drawObject);
		}
		
	}
	
	public void clear() {
		for (IDrawObject drawObject : drawObjects) {
			drawObject.close();
		}
		drawObjects.clear();
	}
	
	public void add(IDrawObject drawObject) {
		drawObjects.add(drawObject);
	}
	
	public List<IDrawObject> getDrawObjects() {
		return drawObjects;
	}
}
