package ch.g_7.graphite.base.ui;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.base.viewmodel.IViewModel;
import ch.g_7.graphite.rendering.Renderable;
import ch.g_7.graphite.util.Color;

public interface IUIPanel extends Renderable {
	
	public Mesh getMesh();
	
	public Vector2f getSize();
	
	public Vector2f getPosition();
	
	public Color getColor();
	
	public Texture getTexture();
}
