package ch.g_7.graphite.base.entity;

import org.joml.Vector3f;
import org.joml.Vector3fc;

import ch.g_7.graphite.base.mesh2d.IMesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public abstract class AbstractEntity implements IEntity {

	protected IMesh mesh;
	protected Texture texture;
	protected Color color;
	protected Vector3f position;
	protected Vector3f rotation;
	protected float scale;
	
	
	public AbstractEntity(IMesh mesh, Texture texture, Color color, Vector3f position, Vector3f rotation, float scale) {
		this.mesh = mesh;
		this.texture = texture;
		this.color = color;
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}
	
	public AbstractEntity() {
		this.position = new Vector3f();
		this.rotation = new Vector3f();
		this.scale = 1;
	}

	@Override
	public Vector3fc getPosition() {
		return position;
	}

	@Override
	public Vector3fc getRotation() {
		return rotation;
	}

	@Override
	public float getScale() {
		return scale;
	}
	
	@Override
	public Color getColor() {
		return color;
	}
	
	@Override
	public Texture getTexture() {
		return texture;
	}
	
	@Override
	public IMesh getMesh() {
		return mesh;
	}
	
	@Override
	public void close() {
		if(texture!=null) {
			texture.close();
		}
		mesh.close();
	}

	@Override
	public void init() {
		mesh.init();
	}

}
