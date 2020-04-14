package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.util.helper.Util;
import org.lwjgl.stb.STBImage;

import java.nio.ByteBuffer;

public class JFXImage implements IJFXImage, ITexture {

    private ITexture texture;

    private boolean redraw;

    private int preferedWidth;
    private int preferedHeight;
    private boolean resizable;


    @Override
    public void draw(ByteBuffer pixels) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean requiresRedraw() {
        return redraw;
    }

    @Override
    public void bind() {
        Util.ifNotNull(texture, ITexture::bind);
    }

    @Override
    public void unbind() {
        Util.ifNotNull(texture, ITexture::unbind);
    }

    @Override
    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    @Override
    public int getWidth() {
        return texture.getWidth();
    }

    @Override
    public void setWidth(int width) {
        this.preferedWidth = width;
        this.redraw = true;
    }

    @Override
    public int getHeight() {
        return texture.getHeight();
    }

    @Override
    public void setHeight(int height) {
       this.preferedHeight = height;
       this.redraw = true;
    }
}
