package ch.g_7.graphite.base.material;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.util.IColor;

public interface IMaterial {
	
	IColor getColor();
	
	ITexture getTexture();
	
	VBO[] getVBOs();

}
