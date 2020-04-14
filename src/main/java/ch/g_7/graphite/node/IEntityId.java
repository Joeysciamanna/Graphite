package ch.g_7.graphite.node;

import ch.g_7.util.common.IIdentifier;

public interface IEntityId<T extends Enum<T> & IEntityId<T>> extends IIdentifier {
}
