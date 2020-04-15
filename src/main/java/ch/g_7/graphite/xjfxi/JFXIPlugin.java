package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.core.IApplication;
import ch.g_7.graphite.plugin.AbstractPlugin;
import ch.g_7.graphite.plugin.IPlugin;
import ch.g_7.graphite.plugin.IPluginInterface;
import ch.g_7.graphite.plugin.IPluginType;
import ch.g_7.util.common.DynamicIdentifier;
import com.sun.javafx.application.PlatformImpl;

public class JFXIPlugin extends AbstractPlugin {

    public static final String NAME = "jfxi_plugin";
    public static final String VERSION = "1.0";

    private JFXIInterface jfxiInterface;

    public JFXIPlugin() {
        super(NAME, VERSION);
    }

    @Override
    public void install(IApplication application) {
        PlatformImpl.startup(()->{});
        jfxiInterface = new JFXIInterface(application.getWindow(), application.getInputManager());
    }

    @Override
    public IPluginInterface getInterface() {
        return jfxiInterface;
    }

    @Override
    public void update(float deltaMillis) { }

    @Override
    public void init() {

    }

    @Override
    public void close() { }

}
