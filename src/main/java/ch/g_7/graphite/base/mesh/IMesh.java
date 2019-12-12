package ch.g_7.graphite.base.mesh;

import java.io.Closeable;

import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.util.stuff.Initializable;


public interface IMesh extends Initializable, Closeable{
	
	int getVerticesCount();
	
	VAO getVAO();
	
	@Override
    void close();

}
