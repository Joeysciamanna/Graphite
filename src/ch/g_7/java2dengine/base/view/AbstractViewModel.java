package ch.g_7.java2dengine.base.view;

import ch.g_7.java2dengine.base.mesh.AbstractMesh;
import ch.g_7.java2dengine.texture.Texture;
import ch.g_7.java2dengine.util.Color;

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
