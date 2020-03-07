package ch.g_7.graphite.rendering;

import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.entity.EntityRenderClass;
import ch.g_7.graphite.rendering.ui.UIRenderClass;
import ch.g_7.graphite.ui.IUIRootContainer;
import ch.g_7.util.common.GenericProducerType;

public class RenderType {

	public static final GenericProducerType<UIRenderClass<IUIRootContainer>> UI = new GenericProducerType<>(()->new UIRenderClass<>("UI"));
	public static final GenericProducerType<EntityRenderClass<IEntity>> ENTITIES = new GenericProducerType<>(()->new EntityRenderClass<>("ENTITIES"));

}
