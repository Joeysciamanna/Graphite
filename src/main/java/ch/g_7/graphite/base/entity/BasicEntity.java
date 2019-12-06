package ch.g_7.graphite.base.entity;

import org.joml.Vector3f;

import ch.g_7.graphite.base.mesh.AbstractMesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public class BasicEntity extends AbstractEntity {

	
	public void setMesh(AbstractMesh mesh) {
		this.mesh = mesh;
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}
}
