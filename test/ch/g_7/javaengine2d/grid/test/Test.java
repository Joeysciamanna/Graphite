package ch.g_7.javaengine2d.grid.test;

import java.io.IOException;

import ch.g_7.javaengine2d.base.mesh.SquareMesh;
import ch.g_7.javaengine2d.base.object.BasicGameObject;
import ch.g_7.javaengine2d.base.object.Camera;
import ch.g_7.javaengine2d.base.view.BasicViewModel;
import ch.g_7.javaengine2d.core.GameEngine;
import ch.g_7.javaengine2d.core.GameLogic;
import ch.g_7.javaengine2d.core.Window;
import ch.g_7.javaengine2d.render.BasicColorRenderer;
import ch.g_7.javaengine2d.render.BasicColorShaderProgram;
import ch.g_7.javaengine2d.util.Color;
import ch.g_7.javaengine2d.util.Pos3d;

public class Test implements GameLogic {

	private static GameEngine engine;
	
	public static void main(String[] args) throws IOException {
		BasicColorShaderProgram shaderProgram = new BasicColorShaderProgram();
		BasicColorRenderer renderer = new BasicColorRenderer(shaderProgram);
		Camera camera = new Camera(renderer);
		Window window = new Window("test", 200, 200, camera);
		engine = new GameEngine(window, new Test());

		engine.start();
	}

	@Override
	public void init() {
		engine.getWindow().setVisible(true);
		engine.getWindow().setBackgroundColor(new Color(java.awt.Color.ORANGE));

		engine.getDimension().add(new BasicGameObject(new Pos3d(0, 0, 0), new BasicViewModel(new Color(255, 0, 255, 0), new SquareMesh(1))));                        

	}
	
	



	
	
	
	
	
	
	
	

}
