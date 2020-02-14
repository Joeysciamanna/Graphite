package ch.g_7.graphite.test.draw;

import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.TextureUtil;
import ch.g_7.util.resource.IDepender;
import org.joml.Vector2f;

import ch.g_7.graphite.draw.DrawContext2d;
import ch.g_7.graphite.draw.drawable.BasicDrawable;
import ch.g_7.graphite.util.Color;

import java.io.IOException;

public class SquareObject extends BasicDrawable {

	private final static Image IMAGE;
	private int x, y;


	static {
		Image image = null;
		try {
			image = TextureUtil.loadImage("C:\\-\\workspace\\java\\graphite\\src\\test\\resources\\textures\\square3.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		IMAGE = image;
	}


	public SquareObject(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(DrawContext2d drawContext) {
		drawContext.addTexture(IMAGE, new Vector2f(x,y), new Vector2f(IMAGE.getWidth(),IMAGE.getHeight()));
	}

	@Override
	protected void doInit() {
		super.doInit();
		IMAGE.bind(this);
	}

	@Override
	protected void doClose() {
		super.doClose();
		IMAGE.unbind(this);
	}
}
