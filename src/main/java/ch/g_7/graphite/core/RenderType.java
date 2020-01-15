package ch.g_7.graphite.core;

import ch.g_7.graphite.draw.Drawable;
import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.RenderCluster;
import ch.g_7.graphite.rendering.draw.DrawRenderCluster;
import ch.g_7.graphite.rendering.draw.DrawRenderer;
import ch.g_7.graphite.rendering.entity.EntityRenderCluster;
import ch.g_7.graphite.rendering.entity.EntityRenderer;
import ch.g_7.graphite.rendering.ui.UIRenderCluster;
import ch.g_7.graphite.rendering.ui.UIRenderer;
import ch.g_7.graphite.ui.IUIRootContainer;

public class RenderType {
	
	public static final RenderCluster<IUIRootContainer, UIRenderer> UI = new UIRenderCluster();
	public static final RenderCluster<IEntity, EntityRenderer> ENTITIES = new EntityRenderCluster();
	public static final RenderCluster<Drawable, DrawRenderer> DRAWABLE = new DrawRenderCluster();
	

}
