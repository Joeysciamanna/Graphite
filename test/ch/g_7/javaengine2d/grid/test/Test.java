package ch.g_7.javaengine2d.grid.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Future;

import ch.g_7.javaengine2d.base.mesh.CubeMesh;
import ch.g_7.javaengine2d.base.object.BasicGameObject;
import ch.g_7.javaengine2d.base.object.Camera;
import ch.g_7.javaengine2d.base.view.BasicViewModel;
import ch.g_7.javaengine2d.core.GameEngine;
import ch.g_7.javaengine2d.core.GameLogic;
import ch.g_7.javaengine2d.core.Window;
import ch.g_7.javaengine2d.process.AsyncProcess;
import ch.g_7.javaengine2d.process.Process;
import ch.g_7.javaengine2d.process.ProcessIntervalBuffer;
import ch.g_7.javaengine2d.render.BasicGridRenderer;
import ch.g_7.javaengine2d.render.BasicGridShaderProgram;
import ch.g_7.javaengine2d.texture.Texture;
import ch.g_7.javaengine2d.util.Color;
import ch.g_7.javaengine2d.util.Pos3d;

public class Test implements GameLogic {

	private static GameEngine engine;
	private static int[][] DIRECTIONS = {{-1,0},{0,-1},{1,0},{0,1}};
	
	public static void main(String[] args) throws IOException {
		BasicGridShaderProgram shaderProgram = new BasicGridShaderProgram();
		BasicGridRenderer renderer = new BasicGridRenderer(shaderProgram);
		Camera camera = new Camera(renderer);
		Window window = new Window("test", 200, 200, camera);
		engine = new GameEngine(window, new Test());

		engine.start();
	}

	@Override
	public void init() {
		engine.getWindow().setVisible(true);
		engine.getWindow().setBackgroundColor(new Color(java.awt.Color.ORANGE));
		try {
			engine.getDimension().add(new BasicGameObject(new Pos3d(0, 0, 1), new BasicViewModel(new Texture("C:/Users/Joey Sciamanna/git/Java2DEngine/res/textures/square.png"), new CubeMesh(1))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	



	
	
	
	
	
	
	
	

}
