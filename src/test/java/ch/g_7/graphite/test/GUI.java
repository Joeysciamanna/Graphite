package ch.g_7.graphite.test;

import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.base.texture.TextureKey;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.graphite.ui.UIButton;
import ch.g_7.graphite.ui.UIRootContainer;
import ch.g_7.graphite.ui.layout.CenterLayoutPanel;
import ch.g_7.graphite.ui.layout.ListLayoutPanel;
import ch.g_7.graphite.ui.layout.SpaceSharingLayoutPanel;
import ch.g_7.graphite.ui.util.IUIViewIdentifier;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.helper.AppInitializer;
import ch.g_7.util.io.LocalFileLoader;
import org.lwjgl.glfw.GLFW;

public class GUI extends Application {

	private UIRootContainer mainMenu;

	private ListLayoutPanel optionPanel;

	public GUI(String name) {
		super(name);
	}

	public static void main(String[] args) {
		new GUI("GUI Test").start();
	}

	@Override
	public void init() {

		AppInitializer appInitializer = new AppInitializer(true, "GUI Test", new LocalFileLoader() {});
		appInitializer.addConsoleLoggers();

		Texture square1 = ResourceManager.getActive().allocateFromEngine(new TextureKey("textures/square1.png"));
		Texture square2 = ResourceManager.getActive().allocateFromEngine(new TextureKey("textures/square3.png"));

		mainMenu = new UIRootContainer(getWindow(), ViewId.MAIN);
		getWorld().addEntity(mainMenu);


		SpaceSharingLayoutPanel sharingLayoutPanel = new SpaceSharingLayoutPanel();
		mainMenu.add(sharingLayoutPanel);

		optionPanel = new ListLayoutPanel(ListLayoutPanel.X_AXIS);
		optionPanel.setColor(new Color(0, 255, 0));
		optionPanel.getHeight().reset().addPF(5).addPixel(20);
		optionPanel.getPlaceHolder().reset().addPixel(5);
		sharingLayoutPanel.setMainPanel(optionPanel, SpaceSharingLayoutPanel.BUTTOM);

		UIButton settingsButton = new UIButton();
		settingsButton.getWidth().reset().add(settingsButton.getMaxHeight());
		settingsButton.setTexture(square1);
		optionPanel.add(settingsButton);

		UIButton wikiButton = new UIButton();
		wikiButton.getWidth().reset().add(wikiButton.getMaxHeight());
		wikiButton.setTexture(square2);
		optionPanel.add(wikiButton);

		CenterLayoutPanel buttonPanel = new CenterLayoutPanel();
		buttonPanel.setColor(new Color(0, 255, 255));
		sharingLayoutPanel.setAdjustablePanel(buttonPanel);

		ListLayoutPanel buttonsPanel = new ListLayoutPanel(ListLayoutPanel.Y_AXIS);
		buttonsPanel.setColor(new Color(0, 0, 255));
		buttonsPanel.getPlaceHolder().addPixel(20).addPF(5);
		buttonsPanel.getWidth().reset().addPixel(100).addPF(20);
		buttonsPanel.getHeight().reset().addPixel(50).addPF(20);
		buttonPanel.set(buttonsPanel);

		UIButton startGame = new UIButton();
		startGame.getHeight().reset().addPixel(20).addPF(10);
		startGame.setColor(new Color(255, 255, 0));
		buttonsPanel.add(startGame);



		mainMenu.setVisible(true);

		mainMenu.recalculate();

		getWindow().setVisible(true);
		getWindow().setSize(500, 500);

	}

	@Override
	public void update(float deltaMillis) {
		if(getWindow().isKeyPressed(GLFW.GLFW_KEY_R)){
			mainMenu.recalculate();
			System.out.println("recalculated");
		}
		if(getWindow().isKeyPressed(GLFW.GLFW_KEY_F)) {
			System.out.println("RENDER FPS:      " + getTimer().getLPS());
			System.out.println("UPDATE FPS:      " + updateLoop.getTimer().getLPS());
			System.out.println("Update Delta:    " + deltaMillis);
			System.out.println("Update FPS Calc: " + 1000/deltaMillis);
		}

	}

	enum ViewId implements IUIViewIdentifier<ViewId>{
	    MAIN;
    }



}
