package ch.g_7.graphite.input;

import ch.g_7.util.listener.IActionIdentifier;

public interface IInputAction<T extends Enum<T> & IInputAction<T>> extends IActionIdentifier<T> {


}
