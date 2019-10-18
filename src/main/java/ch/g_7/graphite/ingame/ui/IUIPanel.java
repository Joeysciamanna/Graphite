package ch.g_7.graphite.ingame.ui;

import ch.g_7.graphite.ingame.mesh.AbstractMesh;
import ch.g_7.graphite.ingame.texture.Texture;
import ch.g_7.graphite.util.Color;

public interface IUIPanel extends IUIContainer {

	AbstractMesh getMesh();

	Color getColor();

	Texture getTexture();

	void setFather(IUIContainer container);
	
	IUIContainer getFather();
}
