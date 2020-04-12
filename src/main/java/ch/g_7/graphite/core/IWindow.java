package ch.g_7.graphite.core;

import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.rendering.IRenderResource;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;
import org.joml.Vector2ic;

public interface IWindow extends Initializable, Closeable, IRenderResource, Updatable {

    boolean setTitle(String title);

    void setSize(int width, int height);

    Vector2ic getSize();

    void setPosition(int x, int y);

    Vector2ic getPosition();

    void setVisible(boolean visible);

    boolean isVisible();

    boolean shouldClose();

    void setClearColor(Color color);

    void requestFocus();
}
