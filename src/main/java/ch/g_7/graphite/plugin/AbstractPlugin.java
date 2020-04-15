package ch.g_7.graphite.plugin;

import ch.g_7.graphite.core.IApplication;
import ch.g_7.graphite.xjfxi.JFXIInterface;
import ch.g_7.util.common.DynamicIdentifier;

public abstract class AbstractPlugin implements IPlugin {


    private final String name;
    private final String version;
    public final IPluginType pluginType;

    /**
     * @param name name of the Plugin
     * @param version version of the Plugin (1.0, 4.3, 2.12, ...)
     */
    public AbstractPlugin(String name, String version) {
        this.name = name;
        this.version = version;
        this.pluginType = new PluginType(name);
    }


    private static class PluginType extends DynamicIdentifier implements IPluginType{
        public PluginType(String name) {
            super(name);
        }
    }

    @Override
    public boolean isNeverVersion(String version) {
        return versionDifference(version) > 0;
    }

    @Override
    public boolean isOlderVersion(String version) {
        return versionDifference(version) < 0;
    }

    protected int versionDifference(String version){
        String[] args = version.split("\\.");
        String[] selfArgs = this.version.split("\\.");
        int v = Integer.parseInt(args[0]) * 10 + Integer.parseInt(args[1]);
        int selfV = Integer.parseInt(selfArgs[0]) * 10 + Integer.parseInt(selfArgs[1]);
        return selfV - v;
    }

    @Override
    public IPluginType getType() {
        return pluginType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

}
