package ch.g_7.graphite.base.ui;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public interface IUIPanel extends IUIContainer {

	Mesh getMesh();

	Color getColor();

	Texture getTexture();

	void setFather(IUIContainer container);
	
	IUIContainer getFather();
}
