package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.core.Application;
import com.sun.javafx.stage.EmbeddedWindow;

public class JFXIntegration {

    private static Application application;
    private static GraphiteHostInterface hostInterface;
    private static EmbeddedWindow embeddedWindow;

    public static void init(Application application){
        JFXIntegration.application = application;
        JFXIntegration.hostInterface = new GraphiteHostInterface();
        JFXIntegration.embeddedWindow = new EmbeddedWindow(hostInterface);


    }

}
