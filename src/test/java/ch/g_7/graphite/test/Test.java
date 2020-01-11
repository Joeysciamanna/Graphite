package ch.g_7.graphite.test;

import java.io.IOException;

import org.joml.Vector3f;

import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.text.GlyphFactoryProducer;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.core.RenderType;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.entity.ViewModel;
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
		
		Texture square1 = new SecureRunner<Void, Texture>(() -> Texture.getTexture("C:\\Users\\Joey Sciamanna\\git\\Graphite\\src\\test\\resources\\textures\\square.png", 16, 16)).get();

		Texture glypq = null;
		try {
			glypq = Texture.getSprite("C:\\Users\\Joey Sciamanna\\git\\Graphite\\src\\main\\resources\\fonts\\font-sprite.png", 23, 26, 0,0, 265, 256);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		ViewModel viewModel = new ViewModel();
		viewModel.setMesh(MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_MIDDLE).build());
		viewModel.setTexture(glypq);
		entity1 = new Entity();
		entity1.setViewModel(viewModel);
		entity1.setPosition(new Vector3f(0, 0, 0));
		
		getDimension().addObj(entity1, RenderType.ENTITIES);

		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
}
