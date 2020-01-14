package ch.g_7.graphite.base.texture;

import ch.g_7.util.common.Initializable;

public interface ITexture extends Initializable, AutoCloseable{

	int getId();
	
	void bind();
	
	void unbind();
	
	void close();
	
	int getWidth();
	
	int getHeight();

	boolean isSprite();
}
