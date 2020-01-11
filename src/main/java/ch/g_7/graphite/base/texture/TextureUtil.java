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


	public static ByteBuffer loadTexture(String absolutePath) throws IOException {

		ByteBuffer buf;
		// Load Texture file
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer w = stack.mallocInt(1);
			IntBuffer h = stack.mallocInt(1);
			IntBuffer channels = stack.mallocInt(1);

			buf = stbi_load(absolutePath, w, h, channels, 4);
			if (buf == null) {
				throw new IOException("Image file [" + absolutePath + "] not loaded: " + stbi_failure_reason());
			}

		}
		return buf;
	}

	public static Texture extractSprite(ByteBuffer buffer, int textureWidth, int textureHeight, int x, int y, int width, int height) {
		byte[] bytes = new byte[buffer.remaining()];
		buffer.get(bytes);
		byte[] pixels = new byte[width*height*4];
		for (int i = 0; i < bytes.length; i+=4) {
			int xPos = i % width;
			int yPos = i / width;
			if (xPos > x && xPos < width + x && yPos > y && yPos < height + y) {
				pixels[i + 0] = bytes[i + 0];
				pixels[i + 1] = bytes[i + 1];
				pixels[i + 2] = bytes[i + 2];
				pixels[i + 3] = bytes[i + 3];
			}
		}
		return toTexture(ByteBuffer.wrap(pixels), width, height);
	}

	public static Texture toTexture(ByteBuffer buffer, int width, int height) {

		int id = glGenTextures();

		glBindTexture(GL_TEXTURE_2D, id);

		glPixelStorei(GL_UNPACK_ALIGNMENT, 1);

		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

		glGenerateMipmap(GL_TEXTURE_2D);

		return new Texture(id, width, height);
	}
}
