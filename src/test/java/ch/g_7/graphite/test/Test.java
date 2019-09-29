package ch.g_7.graphite.test;

import java.io.IOException;

import ch.g_7.graphite.base.mesh.SquareMesh;
import ch.g_7.graphite.base.object.BasicGameEntity;
import ch.g_7.graphite.base.object.Camera;
import ch.g_7.graphite.base.view.BasicViewModel;
import ch.g_7.graphite.core.Engine;
import ch.g_7.graphite.core.Initializable;
import ch.g_7.graphite.core.Window;
import ch.g_7.graphite.mover.DirectionalMover;
import ch.g_7.graphite.process.ProcessIntervalBuffer;
import ch.g_7.graphite.render.BasicRenderer;
import ch.g_7.graphite.render.BasicShaderProgram;
import ch.g_7.graphite.util.Color;
import ch.g_7.graphite.util.Dimension2d;
import ch.g_7.graphite.util.Pos3d;

public class Test implements Initializable {
	
	public static void main(String[] args) throws IOException {
		BasicShaderProgram shaderProgram = new BasicShaderProgram();
		BasicRenderer renderer = new BasicRenderer(shaderProgram);
		Camera camera = new Camera(renderer);
		Window window = new Window("test", 200, 200, camera);
		Engine engine = new Engine(window, new Test());
		engine.start();
	}


	public void init(Engine engine) {
		engine.getWindow().setVisible(true);
		engine.getWindow().setBackgroundColor(new Color(java.awt.Color.GRAY));
		BasicGameEntity entity = new BasicGameEntity(new Pos3d(0, 0, 0), new BasicViewModel(new Color(0,0,255,0), new SquareMesh(1)));
		engine.getDimension().add(entity);
		engine.getGameLoop().addProcessInterval(new ProcessIntervalBuffer<Engine>(new DirectionalMover(new Dimension2d(0.01, 0.01), entity), 20));
	}
	
	

}
