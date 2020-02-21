package ch.g_7.graphite.test;

import ch.g_7.graphite.base.texture.Image;
import ch.g_7.graphite.base.texture.ImageKey;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.graphite.ui.UIButton;
import ch.g_7.graphite.ui.UIRootContainer;
import ch.g_7.graphite.ui.layout.CenterLayoutPanel;
import ch.g_7.graphite.ui.layout.ListLayoutPanel;
import ch.g_7.graphite.ui.layout.SpaceSharingLayoutPanel;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.helper.AppInitializer;

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

		AppInitializer appInitializer = new AppInitializer(true, "GUI Test", new Object() {});
		appInitializer.addConsoleLoggers();

		Image square1 = ResourceManager.getActive().getEngineResource(new ImageKey("textures/square1.png"));  //imageLoader.apply("C:\\-\\workspace\\java\\graphite\\src\\test\\resources\\textures\\square1.png");
		Image square2 = ResourceManager.getActive().getEngineResource(new ImageKey("textures/square3.png"));  //imageLoader.apply("C:\\-\\workspace\\java\\graphite\\src\\test\\resources\\textures\\square3.png");
		
		mainMenu = new UIRootContainer(getWindow());
		getDimension().addObj(mainMenu, RenderType.UI);
		
		
		SpaceSharingLayoutPanel sharingLayoutPanel = new SpaceSharingLayoutPanel();
		mainMenu.add(sharingLayoutPanel);
		
		optionPanel = new ListLayoutPanel(ListLayoutPanel.X_AXIS);
		optionPanel.setColor(new Color(0, 255, 0));
		optionPanel.getPreferedHeight().reset().addPF(5).addPixel(20);
		optionPanel.getPlaceHolder().reset().addPixel(5);
		sharingLayoutPanel.setMainPanel(optionPanel, SpaceSharingLayoutPanel.BUTTOM);

		UIButton settingsButton = new UIButton();
		settingsButton.getPreferedWidth().reset().add(settingsButton.getMaxHeight());
		settingsButton.setTexture(square1);
		optionPanel.add(settingsButton);
		
		UIButton wikiButton = new UIButton();
		wikiButton.getPreferedWidth().reset().add(wikiButton.getMaxHeight());
		wikiButton.setTexture(square2);
		optionPanel.add(wikiButton);
		
		CenterLayoutPanel buttonPanel = new CenterLayoutPanel();
		buttonPanel.setColor(new Color(0, 255, 255));
		sharingLayoutPanel.setAdjustablePanel(buttonPanel);
		
		ListLayoutPanel buttonsPanel = new ListLayoutPanel(ListLayoutPanel.Y_AXIS);
		buttonsPanel.setColor(new Color(0, 0, 255));
		buttonsPanel.getPlaceHolder().addPixel(20).addPF(5);
		buttonsPanel.getPreferedWidth().reset().addPixel(100).addPF(20);
		buttonsPanel.getPreferedHeight().reset().addPixel(50).addPF(20);
		buttonPanel.set(buttonsPanel);
		
		UIButton startGame = new UIButton();
		startGame.getPreferedHeight().reset().addPixel(20).addPF(10);
		startGame.setColor(new Color(255, 255, 0));
		buttonsPanel.add(startGame);
		
		
		
		mainMenu.setVisible(true);
		
		mainMenu.recalculate();
		
		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
		
	}
	


}
