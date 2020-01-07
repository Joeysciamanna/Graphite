package ch.g_7.graphite.node;

public class NodeCluster<T extends INode> extends Cluster<T> {

	private Cluster<? super T> father;
	
	public NodeCluster(Cluster<? super T> father) {
		this.father = father;
	}
	
	@Override
	public void addNode(T node) {
		father.addNode(node);
		super.addNode(node);
	}
	
	@Override
	public void removeNode(INode node) {
		super.removeNode(node);
		father.removeNode(node);
	}
	
	
}
