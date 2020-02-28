package ch.g_7.graphite.base.texture;

import org.lwjgl.system.MemoryStack;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;
import static org.lwjgl.stb.STBImage.*;


public class TextureLoader {


    static Image loadImage(InputStream inputStream) throws IOException {
        byte[] bytes = inputStream.readAllBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        return loadImage(byteBuffer);
    }



    static Image loadImage(ByteBuffer imageBuffer) {
        if(!imageBuffer.isDirect()) throw new IllegalArgumentException("ByteBuffer must be direct");
        ByteBuffer buf;
        int id, height, width;
        // Load Texture file
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer channels = stack.mallocInt(1);

            buf = stbi_load_from_memory(imageBuffer, w, h, channels, 4);
            if (buf == null) {
                throw new RuntimeException(stbi_failure_reason());
            }
            width = w.get();
            height = h.get();
        }

        id = createTexture(buf, width, height);
        stbi_image_free(buf);
        
        return new Image(id, width, height);
    }

    private static int createTexture(ByteBuffer buf, int width , int height) {
       
        int textureId = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, textureId);


        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buf);
        
        glGenerateMipmap(GL_TEXTURE_2D);

        return textureId;
    }
	
	
	static Sprite loadSprite(Image image, int x, int y, int width, int height) {
		return new Sprite(image, x, y, width+x, height+y);
	}

}
