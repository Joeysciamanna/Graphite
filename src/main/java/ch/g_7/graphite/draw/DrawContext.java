package ch.g_7.graphite.draw;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.lwjgl.opengl.GL11;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.util.Color;

public class DrawContext {

	private List<IDrawObject> drawObjects;
	private DrawObject drawObject;

	public DrawContext() {
		this.drawObjects = new ArrayList<>();
		drawObject = new DrawObject();
	}

	public void setBrushColor(Color color) {
		drawObject.getViewModel().setColor(color);

	}

	public void setBrushTexture(ITexture texture) {
		drawObject.getViewModel().setTexture(texture);
	}

	public void addLine(Vector3fc from, Vector3fc to) {
		drawObject.getViewModel().setMesh(new Mesh(new float[] { from.x(), from.y(), from.z(), to.x(), to.y(), to.z() },
				new int[] { 0, 1 }, new float[] { 0, 0, 1, 1 }));
		drawObject.setGLDrawMethod(GL11.GL_LINES);
		next();
	}

	public void addTexture(ITexture texture, Vector3fc position, Vector2fc size) {
		setBrushTexture(texture);
		addRectangle(position, size);
		next();
	}

	public void addRectangle(Vector3fc position, Vector2fc size) {
		drawObject.getViewModel().setMesh(MeshFactory2d.getRectangle(size.x(), size.y()).build());
		drawObject.getTransformation().setPosition(new Vector3f(position));
		drawObject.setGLDrawMethod(GL11.GL_TRIANGLES);
		next();
	}

	private void next() {
		if (!drawObject.isEmpty()) {
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

	public void add(IDrawObject entity) {
		drawObjects.add(entity);
	}

	public List<IDrawObject> getDrawObjects() {
		return drawObjects;
	}
}
