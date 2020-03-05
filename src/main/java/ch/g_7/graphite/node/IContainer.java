package ch.g_7.graphite.node;

import java.util.List;

public interface IContainer<T extends  INode<T>>  {

    List<? extends T> getChildren();

}
