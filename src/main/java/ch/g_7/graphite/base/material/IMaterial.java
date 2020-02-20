package ch.g_7.graphite.base.material;

import java.util.Optional;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.util.Color;

public interface IMaterial {
	
	String getName();
	
	Color getColor();
	
	Optional<ITexture> getTexture();
	
	VBO[] getVBOs();

}
