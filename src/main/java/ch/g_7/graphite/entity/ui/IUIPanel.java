package ch.g_7.graphite.entity.ui;

import ch.g_7.graphite.entity.mesh.AbstractMesh;
import ch.g_7.graphite.entity.texture.Texture;
import ch.g_7.graphite.util.Color;

public interface IUIPanel extends IUIContainer {

	AbstractMesh getMesh();

	Color getColor();

	Texture getTexture();

	void setFather(IUIContainer container);
	
	IUIContainer getFather();
	

	
}
