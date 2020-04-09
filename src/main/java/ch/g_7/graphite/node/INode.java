package ch.g_7.graphite.node;


import ch.g_7.util.common.Closeable;

public interface INode<T extends INode<?, ?>, R extends IViewModel> extends Closeable, IContainer<T>, Renderable<R> {

}
