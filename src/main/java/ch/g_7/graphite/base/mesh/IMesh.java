package ch.g_7.graphite.base.mesh;

import java.io.Closeable;

import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.util.able.Initializable;


public interface IMesh extends Initializable, Closeable{
	
	int getVerticesCount();
	
	VAO getVAO();
	
	@Override
    void close();

}
