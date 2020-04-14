package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.core.IWindow;
import ch.g_7.graphite.input.InputManager;
import ch.g_7.graphite.plugin.IPluginInterface;
import com.sun.javafx.stage.EmbeddedWindow;
import javafx.scene.Scene;

public class JFXIInterface implements IPluginInterface {

    private final EmbeddedWindow embeddedWindow;
    private final JFXIHostInterface hostInterface;


    public JFXIInterface(IWindow window, InputManager inputManager) {
        this.hostInterface = new JFXIHostInterface(window);
        this.embeddedWindow = new EmbeddedWindow(hostInterface);
    }

    public void setScene(Scene scene){
        embeddedWindow.setScene(scene);
    }



}
