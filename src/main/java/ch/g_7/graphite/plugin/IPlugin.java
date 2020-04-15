package ch.g_7.graphite.plugin;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.core.IApplication;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

public interface IPlugin extends Initializable, Closeable, Updatable {

    void install(IApplication application);

    IPluginInterface getInterface();

    String getName();

    IPluginType getType();

    String getVersion();

    boolean isNeverVersion(String version);

    boolean isOlderVersion(String version);


}
