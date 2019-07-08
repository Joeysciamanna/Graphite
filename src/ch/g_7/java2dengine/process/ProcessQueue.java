package ch.g_7.java2dengine.process;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Future;

public class ProcessQueue<T,V> implements Process<T, List<V>>{
	
	private Queue<Process<T,V>> processors;
	
	public ProcessQueue() {
		processors = new LinkedList<Process<T,V>>();
	}

	public void add(Process<T,V> processor) {
		processors.add(processor);
	}

	public Process<T,V> pullProcessor() {
		return processors.poll();
	}

	public Queue<Process<T,V>> getProcessors() {
		return processors;
	}

	public void clearProcessors() {
		processors.clear();
	}

	@Override
	public List<V> run(T t) {
		ArrayList<V> values = new ArrayList<>();
		while (!processors.isEmpty()) {
			values.add(processors.poll().run(t));
		}
		return values;
	}
	
	public void runAsync(T t) {
		new AsyncProcess<T,List<V>>(this).run(t);
	}


	
}
