package ch.g_7.graphite.base.viewmodel;

import ch.g_7.graphite.base.mesh.AbstractMesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public interface IViewModel extends AutoCloseable {

	public abstract AbstractMesh getMesh();

	public abstract Color getColor();
	
	public abstract Texture getTexture();
	
	@Override
	void close();
	
}
