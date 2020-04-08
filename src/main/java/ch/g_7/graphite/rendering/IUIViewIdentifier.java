package ch.g_7.graphite.rendering;

import ch.g_7.graphite.node.IEntityIdentifier;

public interface IUIViewIdentifier<T extends Enum<T> & IUIViewIdentifier<T>> extends IEntityIdentifier<T> {
}
