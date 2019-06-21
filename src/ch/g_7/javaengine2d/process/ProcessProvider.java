package ch.g_7.javaengine2d.process;

import java.util.LinkedList;
import java.util.Queue;

public class ProcessProvider<T> {
	
	private Queue<Processor<T>> processors;
	
	public ProcessProvider() {
		processors = new LinkedList<Processor<T>>();
	}

	public void add(Processor<T> processor) {
		processors.add(processor);
	}

	public Processor<T> pullProcessor() {
		return processors.poll();
	}

	public Queue<Processor<T>> getProcessors() {
		return processors;
	}

	public void clearProcessors() {
		processors.clear();
	}
	
}
