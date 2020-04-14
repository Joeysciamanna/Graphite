package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.core.IWindow;
import ch.g_7.graphite.xjfx.injme.JmeFxDnDHandler;
import com.sun.javafx.cursor.CursorFrame;
import com.sun.javafx.embed.AbstractEvents;
import com.sun.javafx.embed.EmbeddedSceneInterface;
import com.sun.javafx.embed.EmbeddedStageInterface;
import com.sun.javafx.embed.HostInterface;

import java.awt.*;

public class GraphiteHostInterface implements HostInterface {


    private final IWindow window;
    private EmbeddedSceneInterface sceneInterface;
    private EmbeddedStageInterface stageInterface;

    public GraphiteHostInterface(Window window) {
        this.application = application;
        this.window = application.getWindow();
    }

    @Override
    public void setEmbeddedStage(EmbeddedStageInterface embeddedStage) {
        this.stageInterface = embeddedStage;

        if(stageInterface == null) return;

        int width = window.getSize().x();
        int height = window.getSize().y();

        stageInterface.setSize(width, height);
        stageInterface.setFocused(true, AbstractEvents.FOCUSEVENT_ACTIVATED);
    }

    @Override
    public void setEmbeddedScene(EmbeddedSceneInterface embeddedScene) {
        this.sceneInterface = embeddedScene;


        if (sceneInterface == null) return;


        sceneInterface.setPixelScaleFactors(1, 1);

        int width = window.getSize().x();
        int height = window.getSize().y();


        sceneInterface.setSize(width, height);
    }


    @Override
    public void repaint() {
        sceneInterface.getPixels()
    }

    @Override
    public void setPreferredSize(int width, int height) {
        window.setSize(width, height);
    }

    @Override
    public boolean requestFocus() {
        window.requestFocus();
        return true;
    }

    @Override
    public void setEnabled(boolean enabled) {

    }

    @Override
    public void setCursor(CursorFrame cursorFrame) {
        //TODO
    }

    @Override
    public boolean grabFocus() {
        requestFocus();
        return true;
    }

    @Override
    public boolean traverseFocusOut(boolean forward) {
        return true;
    }

    @Override
    public void ungrabFocus() { }
}
