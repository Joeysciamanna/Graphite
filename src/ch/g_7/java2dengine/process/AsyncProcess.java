package ch.g_7.java2dengine.process;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncProcess<T, V> implements Process<T, V>, Runnable{

	private Process<T, V> process;
	private T input;
	private V output;
	
	public AsyncProcess(Process<T, V> process) {
		this.process = process;
	}
	
	@Override
	public V run(T t) {
		Thread thread = new Thread(this);
		thread.start();
		return output;
	}
	
	public V getOutput() {
		return output;
	}

	@Override
	public void run() {
		output = process.run(input);
	}
	
}
