package ch.g_7.graphite.test;

import org.joml.Vector3f;

import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.BasicEntity;
import ch.g_7.graphite.entity.ViewModel;
import ch.g_7.graphite.node.RenderCluster;
import ch.g_7.graphite.util.Color;

public class Test extends Application {

	private BasicEntity entity1;
	
	public Test() {
		super("Test");
	}
	
	public static void main(String[] args) {
		new Test().start();
	}
	
	@Override
	protected void init() {

		
		ViewModel viewModel = new ViewModel();
		viewModel.setMesh(MeshFactory2d.getSquare(1).build());
		viewModel.setColor(Color.getColor(255, 255, 0));

		entity1 = new BasicEntity();
		entity1.setViewModel(viewModel);
		entity1.setPosition(new Vector3f(0, 0, -2));
		
		getDimension().addObj(entity1, RenderCluster.ENTITIES);

		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
}
