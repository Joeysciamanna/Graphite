package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.core.IWindow;
import ch.g_7.graphite.core.input.InputManager;
import com.sun.javafx.stage.EmbeddedWindow;

public class JFXIntegration {

    private boolean initialized = true;
    private static GraphiteHostInterface hostInterface;
    private static EmbeddedWindow embeddedWindow;

    public static HostStage init(IWindow window, InputManager inputManager){
        JFXIntegration.hostInterface = new GraphiteHostInterface(application);
        JFXIntegration.embeddedWindow = new EmbeddedWindow(hostInterface);
        return new HostStage(embeddedWindow);
    }

}
