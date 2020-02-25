package ch.g_7.graphite.rendering.entity;

import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.RenderClass;

public class EntityRenderClass<T extends  IEntity> extends RenderClass<T, EntityRenderer>{

	public EntityRenderClass(String name) {
		super(new EntityRenderer(), name);
	}

	@Override
	public void update(float deltaMillis) {
		nodes.forEach((d)->d.update(deltaMillis));
	}
}
