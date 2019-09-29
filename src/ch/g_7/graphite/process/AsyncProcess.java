package ch.g_7.graphite.process;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncProcess<T, V> implements Process<T, Void>{

	private Process<T, V> process;
	private V output;
	
	public AsyncProcess(Process<T, V> process) {
		this.process = process;
	}
	
	@Override
	public Void run(T t) {
		new Thread(() -> output = process.run(t)).start();
		return null;
	}
	
	public V getOutput() {
		return output;
	}

	
}
