package ch.g_7.graphite.core;

import ch.g_7.graphite.draw.Canvas;
import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.RenderCluster;
import ch.g_7.graphite.rendering.entity.EntityRenderer;
import ch.g_7.graphite.rendering.ui.UIRenderer;
import ch.g_7.graphite.ui.IUIRootContainer;

public class RenderType {
	
	public static final RenderCluster<IUIRootContainer, UIRenderer> UI = new RenderCluster<>(new UIRenderer(), "UI");
	public static final RenderCluster<IEntity, EntityRenderer> ENTITIES = new RenderCluster<>(new EntityRenderer(), "ENTITIES");
	public static final Canvas DRAWABLE = new Canvas();
	

}
