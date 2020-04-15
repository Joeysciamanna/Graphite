package ch.g_7.graphite.test;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.xjfxi.JFXIInterface;
import ch.g_7.graphite.xjfxi.JFXIPlugin;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class JFXTest extends Application {

    public JFXTest() {
        super("JFX Test");
    }

    public static void main(String[] args) {
        JFXTest jfxTest = new JFXTest();
        jfxTest.getPluginManager().install(new JFXIPlugin());
        jfxTest.start();
    }


    @Override
    public void init() {
        JFXIInterface jfxiInterface = (JFXIInterface) getPluginManager().getPlugin(JFXIPlugin.NAME).get();
        Button button = new Button("BUTTON");
        Group rootNode = new Group(button);
        Scene scene = new Scene(rootNode, 600, 600);
        scene.setFill(Color.TRANSPARENT);
        jfxiInterface.setScene(scene);


        getWindow().setVisible(true);
        getWindow().setSize(500, 500);
    }
}
