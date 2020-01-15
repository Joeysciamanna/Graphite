package ch.g_7.graphite.base.texture;

import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_UNPACK_ALIGNMENT;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glPixelStorei;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;
import static org.lwjgl.stb.STBImage.stbi_failure_reason;
import static org.lwjgl.stb.STBImage.stbi_load;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.system.MemoryStack;

public class TextureUtil {
	
	
	public static Image loadImage(String path) throws IOException {
		int width, height;

		ByteBuffer buf;
		// Load Texture file
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer w = stack.mallocInt(1);
			IntBuffer h = stack.mallocInt(1);
			IntBuffer channels = stack.mallocInt(1);

			buf = stbi_load(path, w, h, channels, 4);
			if (buf == null) {
				throw new IOException("Image file [" + path + "] not loaded: " + stbi_failure_reason());
			}
			width = w.get();
			height = h.get();
		}
		int id = glGenTextures();

		glBindTexture(GL_TEXTURE_2D, id);

		glPixelStorei(GL_UNPACK_ALIGNMENT, 1);

		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buf);

		glGenerateMipmap(GL_TEXTURE_2D);

		return new Image(id, width, height);
	}
	
	public static Sprite loadSprite(Image image, int x, int y, int width, int height) {

		float xScale = 1f / image.getWidth();
		float yScale = 1f / image.getHeight();
		
		float xMin = xScale * x;
		float yMin = 1 - yScale * (y + height);
		
		float xMax = xMin + (xScale * width);
		float yMax = yMin + (yScale * height);
		
		return new Sprite(image, xMin, yMin, xMax, yMax);
	}
}
