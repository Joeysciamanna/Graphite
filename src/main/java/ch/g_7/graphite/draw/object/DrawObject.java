package ch.g_7.graphite.draw.object;

import org.joml.Vector3f;
import org.joml.Vector3fc;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public class DrawObject implements IDrawObject {

	private IMesh mesh;
	
	private Texture texture;
	
	private Color color = Color.getColor(0, 0, 0);
	
	private Vector3f position = new Vector3f();
	
	private float scale = 1;
	
	private Vector3f rotation;
	
	private int glDrawMethod = -1;
	
	public boolean isEmpty() {
		return mesh == null || glDrawMethod == -1;
	}
	
	@Override
	public IMesh getMesh() {
		return mesh;
	}
	
	public void setMesh(IMesh mesh) {
		this.mesh = mesh;
	}

	@Override
	public Texture getTexture() {
		return texture;
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	@Override
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	@Override
	public int getGLDrawMethod() {
		return glDrawMethod;
	}
	
	public void setGlDrawMethod(int glDrawMethod) {
		this.glDrawMethod = glDrawMethod;
	}

	@Override
	public float getScale() {
		return scale;
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}
	
	@Override
	public Vector3fc getRotation() {
		return rotation;
	}
	
	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}
}
