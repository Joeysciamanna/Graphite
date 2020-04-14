package ch.g_7.graphite.node;

public interface IEntity<K extends INode<?,?>, R extends IViewModel> extends INode<K, R>, Updatable {

    IEntityId<?> getId();

}
