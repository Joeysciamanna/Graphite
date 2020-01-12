package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.util.able.Initializable;


public interface IMesh extends Initializable, AutoCloseable {
	
	int getVerticesCount();
	
	VAO getVAO();
	
	@Override
	void close();

	void setTextureCoordinates(float[] textureCoordinates);
}
