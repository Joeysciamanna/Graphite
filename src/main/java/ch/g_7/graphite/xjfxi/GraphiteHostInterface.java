package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.core.Application;
import com.sun.javafx.cursor.CursorFrame;
import com.sun.javafx.embed.EmbeddedSceneInterface;
import com.sun.javafx.embed.EmbeddedStageInterface;
import com.sun.javafx.embed.HostInterface;

public class GraphiteHostInterface implements HostInterface {

    private final Application application;
    private EmbeddedSceneInterface sceneInterface;
    private EmbeddedStageInterface stageInterface;

    public GraphiteHostInterface(Application application) {
        this.application = application;
    }

    @Override
    public void setEmbeddedStage(EmbeddedStageInterface embeddedStage) {
        this.stageInterface = embeddedStage;
    }

    @Override
    public void setEmbeddedScene(EmbeddedSceneInterface embeddedScene) {
        this.sceneInterface = embeddedScene;
    }

    @Override
    public boolean requestFocus() {
        return application.getWindow().r;
    }

    @Override
    public boolean traverseFocusOut(boolean forward) {
        return false;
    }

    @Override
    public void repaint() {

    }

    @Override
    public void setPreferredSize(int width, int height) {

    }

    @Override
    public void setEnabled(boolean enabled) {

    }

    @Override
    public void setCursor(CursorFrame cursorFrame) {

    }

    @Override
    public boolean grabFocus() {
        return false;
    }

    @Override
    public void ungrabFocus() {

    }
}
