package ch.g_7.graphite.base.ui;

import ch.g_7.graphite.base.mesh.AbstractMesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public interface IUIPanel extends IUIContainer {

	AbstractMesh getMesh();

	Color getColor();

	Texture getTexture();

	void setFather(IUIContainer container);
	
	IUIContainer getFather();
}
