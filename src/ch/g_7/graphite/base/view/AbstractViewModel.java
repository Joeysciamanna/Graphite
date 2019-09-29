package ch.g_7.graphite.base.view;

import ch.g_7.graphite.base.mesh.AbstractMesh;
import ch.g_7.graphite.texture.Texture;
import ch.g_7.graphite.util.Color;

public abstract class AbstractViewModel {
	
	public abstract AbstractMesh getMesh();

	public abstract Color getColor();
	
	public abstract Texture getTexture();
	
	public void close() {
		if(getMesh()!=null) {
			getMesh().close();
		}
		if(getTexture()!=null) {
			getTexture().close();
		}
	}
	
}
