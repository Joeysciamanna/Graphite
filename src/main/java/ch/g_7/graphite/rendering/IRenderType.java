package ch.g_7.graphite.rendering;

import ch.g_7.graphite.node.IEntityId;

public interface IRenderType<T extends Enum<T> & IRenderType<T>> extends IEntityId<T> {

}
