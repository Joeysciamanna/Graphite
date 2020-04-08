package ch.g_7.graphite.node;

public interface IEntity<T extends IViewModel, K extends INode<K,?>> extends INode<K, T>, Updatable {

    IEntityIdentifier<?> getId();

}
