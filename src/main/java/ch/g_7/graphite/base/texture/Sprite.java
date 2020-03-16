package ch.g_7.graphite.base.texture;

import org.lwjgl.opengl.GL11;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.mesh.vao.VBOFactory;

@Deprecated
public class Sprite extends Texture {

	private final VBO textureCoordinates;


	Sprite(Texture image, int minX, int minY, int maxX, int maxY) {
		super(image.getId(), (maxX - minX), (maxY - minY));
		float minXT = (float) minX / image.getWidth();
		float minYT = (float) maxY / image.getHeight();
		float maxXT = (float) maxX / image.getWidth();
		float maxYT = (float) minY / image.getHeight();

		float[] textCoords = new float[]{
			minXT, minYT,
			maxXT, minYT,
			maxXT, maxYT,
			minXT, maxYT
		};
		this.textureCoordinates = VBOFactory.getTextureCoordinatesVBO(textCoords);
	}

	@Override
	public void close() {
		super.close();
		textureCoordinates.close();
	}
	

	@Override
	public void bind() {
		super.bind();
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
	}

}
