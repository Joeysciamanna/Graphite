package ch.g_7.javaengine2d.process;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncProcess<T, V> implements Process<T, Future<V>>, Runnable{

	private Process<T, V> process;
	private Future<V> output;
	
	public AsyncProcess(Process<T, V> process) {
		this.process = process;
	}
	
	@Override
	public Future<V> run(T t) {
		ExecutorService executor  = Executors.newSingleThreadExecutor();
		output = executor.submit(() -> {
            return process.run(t);
        });
		return output;
	}
	
	public V getOutput() {
		try {
			return output.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		} 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
