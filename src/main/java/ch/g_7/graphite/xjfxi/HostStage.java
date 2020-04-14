package ch.g_7.graphite.xjfxi;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.scene.Scene;

public class HostStage {

    private final EmbeddedWindow embeddedWindow;

    public HostStage(EmbeddedWindow embeddedWindow) {
        this.embeddedWindow = embeddedWindow;
    }

    public void setScene(Scene scene){
        embeddedWindow.setScene(scene);
    }


}
