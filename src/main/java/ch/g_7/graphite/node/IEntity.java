package ch.g_7.graphite.node;

public interface IEntity<T extends INode<?,?>, R extends IViewModel> extends INode<T, R>, Updatable, Identifiable {

}
