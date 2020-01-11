package ch.g_7.graphite.node;

import ch.g_7.util.able.Initializable;

public interface INode extends Initializable, AutoCloseable {

	@Override
	void close();

	void update(double deltaMillis);

}
