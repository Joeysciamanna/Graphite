package ch.g_7.javaengine2d.base.view;

import ch.g_7.javaengine2d.base.mesh.AbstractMesh;
import ch.g_7.javaengine2d.texture.Texture;
import ch.g_7.javaengine2d.util.Color;

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
