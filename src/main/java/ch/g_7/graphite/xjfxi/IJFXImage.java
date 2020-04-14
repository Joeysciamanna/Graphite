package ch.g_7.graphite.xjfxi;

import java.nio.ByteBuffer;

public interface IJFXImage {

    void draw(ByteBuffer pixels);

    boolean requiresRedraw();

    boolean isResizable();

    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

}
