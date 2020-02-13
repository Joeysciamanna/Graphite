package ch.g_7.graphite.draw;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.resource.Resource;

public class DrawContext2d extends Resource {

	private List<IDrawObject> drawObjects;
	private DrawObject next;

	public DrawContext2d() {
		this.drawObjects = new ArrayList<>();
		next = new DrawObject();
	}

	public void setBrushColor(Color color) {
		next.getViewModel().setColor(color);

	}

	public void setBrushTexture(ITexture texture) {
		next.getViewModel().setTexture(texture);
	}

	public void addLine(Vector2fc from, Vector2fc to) {
		next.getViewModel().setMesh(new Mesh(new float[] { from.x(), from.y(), 0, to.x(), to.y(), 0 },
				new int[] { 0, 1 }, new float[] { 0, 0, 1, 1 }));
		next.setGLDrawMethod(GL11.GL_LINES);
		next();
	}

	public void addTexture(ITexture texture, Vector2fc position, Vector2fc size) {
		setBrushTexture(texture);
		addRectangle(position, size);
	}

	public void addRectangle(Vector2fc position, Vector2fc size) {
		next.getViewModel().setMesh(MeshFactory2d.getRectangle(size.x(), size.y()).build());
		next.getTransformation().setPosition(new Vector3f(position.x(), position.y(), 0));
		next.setGLDrawMethod(GL11.GL_TRIANGLES);
		next();
	}

	private void next() {
		if (!next.isEmpty()) {
			next.bind(this);
			add(next);
			next = new DrawObject(next);
		}

	}
	
	@Override
	protected void doInit() {
	}
	
	@Override
	protected void doClose() {
		for (IDrawObject drawObject : drawObjects) {
			drawObject.unbind(this);
		}
	}

	public void clear() {
		doClose();
		drawObjects.clear();
	}

	public void add(IDrawObject entity) {
		bindTo(entity);
		drawObjects.add(entity);
	}

	public List<IDrawObject> getDrawObjects() {
		return drawObjects;
	}
}
