package ch.g_7.graphite.node;

public interface IEntity<T extends IViewModel> extends INode<IEntity<?>, T>, Updatable {

    IEntityIdentifier<?> getId();

}
