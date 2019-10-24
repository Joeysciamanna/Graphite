package ch.g_7.graphite.entity.viewmodel;

import ch.g_7.graphite.entity.mesh.AbstractMesh;
import ch.g_7.graphite.entity.texture.Texture;
import ch.g_7.graphite.util.Color;

public interface IViewModel extends AutoCloseable {

	public abstract AbstractMesh getMesh();

	public abstract Color getColor();
	
	public abstract Texture getTexture();
	
	@Override
	void close();
	
}
