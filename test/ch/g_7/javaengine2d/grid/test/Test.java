package ch.g_7.javaengine2d.grid.test;

import java.io.IOException;

import ch.g_7.java2dengine.base.mesh.SquareMesh;
import ch.g_7.java2dengine.base.object.BasicGameEntity;
import ch.g_7.java2dengine.base.object.Camera;
import ch.g_7.java2dengine.base.view.BasicViewModel;
import ch.g_7.java2dengine.core.Engine;
import ch.g_7.java2dengine.core.GameLogic;
import ch.g_7.java2dengine.core.Window;
import ch.g_7.java2dengine.render.BasicColorRenderer;
import ch.g_7.java2dengine.render.BasicColorShaderProgram;
import ch.g_7.java2dengine.util.Color;
import ch.g_7.java2dengine.util.Pos3d;

public class Test implements GameLogic {
	
	public static void main(String[] args) throws IOException {
		BasicColorShaderProgram shaderProgram = new BasicColorShaderProgram();
		BasicColorRenderer renderer = new BasicColorRenderer(shaderProgram);
		Camera camera = new Camera(renderer);
		Window window = new Window("test", 200, 200, camera);
		Engine engine = new Engine(window, new Test());
		engine.start();
	}

	@Override
	public void init(Engine engine) {
		engine.getWindow().setVisible(true);
		engine.getWindow().setBackgroundColor(new Color(java.awt.Color.ORANGE));

		engine.getDimension().add(new BasicGameEntity(new Pos3d(0, 0, 0), new BasicViewModel(new Color(255, 0, 255, 0), new SquareMesh(1))));                        

	}
	
	



	
	
	
	
	
	
	
	

}
