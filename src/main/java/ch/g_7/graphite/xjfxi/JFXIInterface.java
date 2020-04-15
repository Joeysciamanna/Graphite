package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.core.IWindow;
import ch.g_7.graphite.input.InputManager;
import ch.g_7.graphite.plugin.IPluginInterface;
import ch.g_7.util.common.Initializable;
import com.sun.javafx.stage.EmbeddedWindow;
import javafx.application.Platform;
import javafx.scene.Scene;

public class JFXIInterface implements IPluginInterface {

    private EmbeddedWindow embeddedWindow;
    private JFXIHostInterface hostInterface;


    public JFXIInterface(IWindow window, InputManager inputManager) {
        Platform.runLater(()->{
            this.hostInterface = new JFXIHostInterface(new JFXImage(), window);
            this.embeddedWindow = new EmbeddedWindow(hostInterface);
        });

    }


    public void setScene(Scene scene){
        embeddedWindow.setScene(scene);
    }


}
