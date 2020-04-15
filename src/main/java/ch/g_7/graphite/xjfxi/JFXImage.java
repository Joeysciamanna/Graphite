package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.util.helper.Util;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;
import static org.lwjgl.stb.STBImage.*;

public class JFXImage implements IJFXImage, ITexture {

    private ITexture texture;

    private boolean redraw;

    private int preferedWidth;
    private int preferedHeight;


    @Override
    public void draw(ByteBuffer pixels) {
        if(!pixels.isDirect()) throw new IllegalArgumentException("ByteBuffer must be direct");
        ByteBuffer buf;
        int id, height, width;
        // Load Texture file
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer channels = stack.mallocInt(1);

            buf = stbi_load_from_memory(pixels, w, h, channels, 4);
            if (buf == null) {
                throw new RuntimeException(stbi_failure_reason());
            }
            width = w.get();
            height = h.get();
        }

        id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, id);


        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buf);

        glGenerateMipmap(GL_TEXTURE_2D);
        stbi_image_free(buf);

        this.texture = new Texture(id, width, height);

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean requiresRedraw() {
        return redraw;
    }

    @Override
    public void bind() {
        Util.ifNotNull(ITexture::bind, texture);
    }

    @Override
    public void unbind() {
        Util.ifNotNull(ITexture::unbind, texture);
    }


    @Override
    public int getWidth() {
        return texture == null ? 0 : texture.getWidth();
    }

    public void setWidth(int width) {
        this.preferedWidth = width;
        this.redraw = true;
    }

    @Override
    public int getHeight() {
        return texture == null ? 0 : texture.getHeight();
    }

    public void setHeight(int height) {
       this.preferedHeight = height;
       this.redraw = true;
    }
}
