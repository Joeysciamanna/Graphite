package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.core.IApplication;
import ch.g_7.graphite.plugin.IPlugin;
import ch.g_7.graphite.plugin.IPluginInterface;
import ch.g_7.graphite.plugin.IPluginType;

public class JFXIPlugin implements IPlugin {

    private static final String NAME = "jfxi_plugin";
    private static final String VERSION = "1.0";

    private JFXIInterface jfxiInterface;

    @Override
    public void install(IApplication application) {
        jfxiInterface = new JFXIInterface(application.getWindow(), application.getInputManager());
    }

    @Override
    public IPluginInterface getInterface() {
        return jfxiInterface;
    }

    @Override
    public void update(float deltaMillis) { }

    @Override
    public void init() { }

    @Override
    public void close() { }

    @Override
    public boolean isNeverVersion(String version) {
        return versionDifference(version) > 0;
    }

    @Override
    public boolean isOlderVersion(String version) {
        return versionDifference(version) < 0;
    }

    private int versionDifference(String version){
        String[] args = version.split("\\.");
        String[] selfArgs = VERSION.split("\\.");
        int v = Integer.parseInt(args[0]) * 10 + Integer.parseInt(args[1]);
        int selfV = Integer.parseInt(selfArgs[0]) * 10 + Integer.parseInt(selfArgs[1]);
        return selfV - v;
    }

    private enum PluginType implements IPluginType<PluginType>{
        JFXI_PLUGIN;
    }

    @Override
    public IPluginType<?> getType() {
        return PluginType.JFXI_PLUGIN;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getVersion() {
        return VERSION;
    }
}
