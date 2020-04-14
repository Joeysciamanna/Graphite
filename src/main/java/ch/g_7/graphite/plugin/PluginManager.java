package ch.g_7.graphite.plugin;

import ch.g_7.graphite.core.IApplication;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PluginManager implements Initializable, Closeable {


    private boolean initialized;
    private final IApplication application;
    private final List<IPlugin> plugins;

    public PluginManager(IApplication application) {
        this.application = application;
        this.plugins = new ArrayList<>();
    }

    public void install(IPlugin plugin){
        if (initialized) throw new IllegalStateException("Plugins can't be added during runtime");
        plugins.add(plugin);
        plugin.install(application);
    }

    @Override
    public void init() {
        initialized = true;
        for (IPlugin plugin : plugins) {
            plugin.init();
        }
    }

    @Override
    public void close() {
        for (IPlugin plugin : plugins) {
            plugin.close();
        }
    }

    public <T extends IPlugin> T getPlugin(IPluginType<?> type) {
        for (IPlugin plugin : plugins) {
            if(plugin.getType().equals(type))
                return (T) plugin;
        }
        return null;
    }

    public <T extends IPluginInterface> Optional<T> getPlugin(String name) {
        for (IPlugin plugin : plugins) {
            if(plugin.getName().equals(name))
                return Optional.of((T) plugin.getInterface());
        }
        return Optional.empty();
    }


}
