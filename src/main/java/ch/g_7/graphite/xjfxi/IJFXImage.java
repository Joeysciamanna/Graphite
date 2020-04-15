package ch.g_7.graphite.xjfxi;

import java.nio.ByteBuffer;

public interface IJFXImage {

    void draw(ByteBuffer pixels);

    boolean requiresRedraw();

    int getWidth();

    int getHeight();

}
