package ch.g_7.graphite.draw.object;

import org.joml.Vector3f;
import org.joml.Vector3fc;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.util.Color;
import ch.g_7.graphite.util.ResourceHandler;

public class DrawObject implements IDrawObject {

	private IMesh mesh;
	
	private Image texture;
	
	private Color color = Color.getColor(0, 0, 0);
	
	private Vector3fc position = new Vector3f();
	
	private float scale = 1;
	
	private Vector3fc rotation = new Vector3f();
	
	private int glDrawMethod = -1;
	
	public DrawObject(IDrawObject drawObject) {
		this.color = drawObject.getColor();
		this.texture = drawObject.getTexture();
	}
	
	
	public DrawObject() {}


	public boolean isEmpty() {
		return mesh == null || glDrawMethod == -1;
	}

	@Override
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}
	
	protected void doInit() {
		if(mesh!=null) mesh.init();
	}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallInitialize(this)) doClose();
	}
	
	protected void doClose() {
		if(mesh!=null) mesh.close();
		if(texture!=null) texture.close();
	}

	
	@Override
	public IMesh getMesh() {
		return mesh;
	}
	
	public void setMesh(IMesh mesh) {
		this.mesh = mesh;
	}

	@Override
	public Image getTexture() {
		return texture;
	}
	
	public void setTexture(Image texture) {
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
	public Vector3fc getPosition() {
		return position;
	}

	public void setPosition(Vector3fc position) {
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