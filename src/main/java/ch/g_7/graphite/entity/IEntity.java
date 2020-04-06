package ch.g_7.graphite.entity;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.rendering.IBasicViewModel;

public interface IEntity<T extends IViewModel> extends INode<IEntity<?>, T>, Updatable {

}
