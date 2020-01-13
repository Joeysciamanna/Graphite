package ch.g_7.graphite.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Cluster<T extends Updatable> {
	
	protected final List<T> nodes;
	
	public Cluster() {
		nodes = new ArrayList<T>();
	}
	
	public void foreach(Consumer<T> consumer) {
		nodes.forEach(consumer);
	}
	
	public void addNode(T node) {
		nodes.add(node);
		node.init();
	}
	
	public void removeNode(IEntity node) {
		node.close();
		nodes.remove(node);
	}
	
	

}
