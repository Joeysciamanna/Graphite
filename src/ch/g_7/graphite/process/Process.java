package ch.g_7.graphite.process;

public interface Process<T,V> {

	public V run(T t);
}
