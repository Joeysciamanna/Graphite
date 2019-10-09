package ch.g_7.graphite.base.ui;

import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.rendering.Renderable;
import ch.g_7.graphite.util.Color;

public interface IUIPanel extends Renderable {
	
	public boolean isVisible();
	
	public List<IUIPanel> getChilds();

	public Mesh getMesh();
	
	public Vector2fc getSize();
	
	public Vector2fc getPosition();
	
	public Color getColor();
	
	public Texture getTexture();
	
	public void recalculate(Vector2ic screenSize);
}
