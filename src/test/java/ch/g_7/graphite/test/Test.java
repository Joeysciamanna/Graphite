package ch.g_7.graphite.test;

import org.joml.Vector3f;

import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.text.GlyphFactoryProducer;
import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.Sprite;
import ch.g_7.graphite.base.texture.TextureUtil;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.core.RenderType;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.entity.ViewModel;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.task.SecureRunner;

public class Test extends Application {

	private Entity entity1;
	
	public Test() {
		super("Test");
	}
	
	public static void main(String[] args) {
		new Test().start();
	}
	
	@Override
	protected void init() {
		
		Image square1 = new SecureRunner<Void, Image>(() -> TextureUtil.loadImage("C:\\Users\\Joey Sciamanna\\git\\Graphite\\src\\test\\resources\\textures\\square.png")).get();

		Sprite sprite = GlyphFactoryProducer.getGlyphFactory().getSprite('a');
		
		ViewModel viewModel = new ViewModel();
		viewModel.setMesh(MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_MIDDLE).build());
		getWindow().setBackgroundColor(Color.getColor(255, 0, 0));
		entity1 = new Entity();
		entity1.setViewModel(viewModel);
		entity1.setPosition(new Vector3f(0, 0, 0));
		
		getDimension().addObj(entity1, RenderType.ENTITIES);
		viewModel.setSprite(sprite);
		
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
}
