package ch.g_7.graphite.node;

import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

public interface Updatable extends Initializable, Closeable{
 
	void update(double deltaMillis);
	
}
