package ch.g_7.graphite.rendering;

import ch.g_7.util.able.Initializable;

public interface Renderable extends AutoCloseable, Initializable {

	@Override
	void close();
	
}
