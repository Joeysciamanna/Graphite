package ch.g_7.graphite.base.texture;

import ch.g_7.util.resource.IResource;

public interface ITexture extends IResource {

	int getId();
	
	void bind();
	
	void unbind();
	
	int getWidth();
	
	int getHeight();

	boolean isSprite();
}
