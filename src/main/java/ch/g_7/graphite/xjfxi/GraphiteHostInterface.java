package ch.g_7.graphite.xjfxi;

import com.sun.javafx.cursor.CursorFrame;
import com.sun.javafx.embed.EmbeddedSceneInterface;
import com.sun.javafx.embed.EmbeddedStageInterface;
import com.sun.javafx.embed.HostInterface;

public class GraphiteHostInterface implements HostInterface {
    @Override
    public void setEmbeddedStage(EmbeddedStageInterface embeddedStage) {

    }

    @Override
    public void setEmbeddedScene(EmbeddedSceneInterface embeddedScene) {

    }

    @Override
    public boolean requestFocus() {
        return false;
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
