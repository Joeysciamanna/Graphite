package ch.g_7.graphite.rendering.type;

import ch.g_7.util.common.IIdentifier;

public interface IRenderType<E extends Enum<E> & IRenderType<E>> extends IIdentifier<E>{

}
