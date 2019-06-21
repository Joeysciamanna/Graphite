package ch.g_7.javaengine2d.grid.test;

import java.awt.Color;
import java.io.IOException;

import javax.swing.text.FieldView;

import ch.g_7.javaengine2d.base.object.Camera;
import ch.g_7.javaengine2d.core.GameEngine;
import ch.g_7.javaengine2d.core.GameLogic;
import ch.g_7.javaengine2d.core.Window;
import ch.g_7.javaengine2d.process.Processor;
import ch.g_7.javaengine2d.render.BasicGridRenderer;
import ch.g_7.javaengine2d.render.BasicGridShaderProgram;
import ch.g_7.javaengine2d.texture.Texture;

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
		GridPanel gridPanel = new GridPanel(10, 10);
		engine.setDimension(gridPanel.getDimension());
		
	}
	
	



	
	
	
	
	
	
	
	

}
