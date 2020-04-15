package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.core.IWindow;
import ch.g_7.graphite.xjfx.injme.JmeFxDnDHandler;
import ch.g_7.util.helper.Util;
import com.sun.javafx.cursor.CursorFrame;
import com.sun.javafx.embed.AbstractEvents;
import com.sun.javafx.embed.EmbeddedSceneInterface;
import com.sun.javafx.embed.EmbeddedStageInterface;
import com.sun.javafx.embed.HostInterface;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryUtil;

import java.awt.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Objects;
import java.util.function.Function;

public class JFXIHostInterface implements HostInterface {

    private final JFXImage image;
    private final IWindow window;
    private EmbeddedSceneInterface sceneInterface;
    private EmbeddedStageInterface stageInterface;

    private ByteBuffer jfxData;
    private IntBuffer jfxIntData;
    private ByteBuffer texData;

    public JFXIHostInterface(JFXImage image, IWindow window) {
        this.image = image;
        this.window = window;
        createBuffers();
    }


    private void createBuffers() {
        Util.ifNotNulls(MemoryUtil::memFree, jfxData, jfxIntData, texData);

        this.jfxData = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4);
        this.jfxIntData = jfxData.asIntBuffer();
        this.texData = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4);
    }


    @Override
    public void repaint() {
        sceneInterface.getPixels(jfxIntData, image.getWidth(), image.getHeight());
        jfxData.flip();

        texData.clear();
        texData.put(jfxData);
        texData.flip();
        texData.position(0);
        image.draw(texData);
    }

    @Override
    public void setEmbeddedStage(EmbeddedStageInterface embeddedStage) {
        this.stageInterface = embeddedStage;

        if (stageInterface == null) return;
        stageInterface.setSize(image.getWidth(), image.getHeight());
        stageInterface.setFocused(true, AbstractEvents.FOCUSEVENT_ACTIVATED);
    }

    @Override
    public void setEmbeddedScene(EmbeddedSceneInterface embeddedScene) {
        this.sceneInterface = embeddedScene;
        if (sceneInterface == null) return;
        sceneInterface.setPixelScaleFactors(1, 1);
        sceneInterface.setSize(image.getWidth(), image.getHeight());
    }

    @Override
    public void setPreferredSize(int width, int height) {
        image.setWidth(width);
        image.setHeight(height);
        createBuffers();
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
        return requestFocus();
    }

    @Override
    public boolean traverseFocusOut(boolean forward) {
        return true;
    }

    @Override
    public void ungrabFocus() { }
}
