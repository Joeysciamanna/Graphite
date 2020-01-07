package ch.g_7.graphite.node;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

abstract class Cluster<T extends INode> {
	
	protected final List<T> nodes;
	
	Cluster() {
		nodes = new ArrayList<T>();
	}
	
	public void foreach(Consumer<INode> consumer) {
		nodes.forEach(consumer);
	}
	
	public void addNode(T node) {
		nodes.add(node);
		node.init();
	}
	
	public void removeNode(INode node) {
		node.close();
		nodes.remove(node);
	}
	
	

}
