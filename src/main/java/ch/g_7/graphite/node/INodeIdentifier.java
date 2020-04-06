package ch.g_7.graphite.node;

import ch.g_7.util.common.IIdentifier;

public interface INodeIdentifier<T extends Enum<T> & INodeIdentifier<T>> extends IIdentifier<T> {
}
