package ch.g_7.graphite.rendering;

import ch.g_7.util.common.IIdentifier;

public interface IRenderType<T extends Enum<T> & IRenderType<T>> extends IIdentifier<T> {

}
