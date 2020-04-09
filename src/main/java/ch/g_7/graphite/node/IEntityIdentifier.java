package ch.g_7.graphite.node;

import ch.g_7.util.common.IIdentifier;

public interface IEntityIdentifier<T extends Enum<T> & IEntityIdentifier<T>> extends IIdentifier<T> {
}
