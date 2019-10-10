package ch.g_7.graphite.rendering;

import ch.g_7.util.stuff.Initializable;

public interface Renderable extends AutoCloseable, Initializable {

	@Override
	void close();
	
}
