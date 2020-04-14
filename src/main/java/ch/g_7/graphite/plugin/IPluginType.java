package ch.g_7.graphite.plugin;

import ch.g_7.util.common.IIdentifier;

public interface IPluginType<T extends Enum<T> & IPluginType<T>> extends IIdentifier {
}
