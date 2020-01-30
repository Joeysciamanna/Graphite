package ch.g_7.graphite.rendering;

import ch.g_7.graphite.rendering.draw.DrawRenderClass;
import ch.g_7.graphite.rendering.entity.EntityRenderClass;
import ch.g_7.graphite.rendering.ui.UIRenderClass;
import ch.g_7.util.common.GenericProducerType;

public class RenderType {

	public static final GenericProducerType<UIRenderClass>     UI       = new GenericProducerType<>(()->new UIRenderClass());
	public static final GenericProducerType<EntityRenderClass> ENTITIES = new GenericProducerType<>(()->new EntityRenderClass());
	public static final GenericProducerType<DrawRenderClass>   DRAWABLE = new GenericProducerType<>(()->new DrawRenderClass());

}
