package ch.g_7.graphite.node;

import ch.g_7.util.able.Initializable;

public interface INode extends Initializable, AutoCloseable {

	void init();

	@Override
	void close();

	void update(double deltaMillis);

}
