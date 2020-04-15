package ch.g_7.graphite.rendering;

import ch.g_7.graphite.node.IEntityId;
import ch.g_7.util.common.IEnumIdentifier;

public interface IRenderType<T extends Enum<T> & IRenderType<T>> extends IEnumIdentifier<T> {

}
