package ch.g_7.graphite.test;

import org.joml.Vector3f;

import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.entity.ViewModel;
import ch.g_7.graphite.node.RenderCluster;
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
		
		Texture square1 = new SecureRunner<Void, Texture>(() -> new Texture(
				"C:\\Users\\Joey Sciamanna\\git\\Graphite\\src\\main\\resources\\textures\\square.png")).get();
		
		ViewModel viewModel = new ViewModel();
		viewModel.setMesh(MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_MIDDLE).build());
		viewModel.setTexture(square1);
		entity1 = new Entity();
		entity1.setViewModel(viewModel);
		entity1.setPosition(new Vector3f(0, 0, 0));
		
		getDimension().addObj(entity1, RenderCluster.ENTITIES);

		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
}
