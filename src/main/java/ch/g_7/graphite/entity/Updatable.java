package ch.g_7.graphite.entity;

import ch.g_7.graphite.util.Closeable;
import ch.g_7.util.able.Initializable;

public interface Updatable extends Initializable, Closeable{
 
	void update(double deltaMillis);
	
}
