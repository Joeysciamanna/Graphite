package ch.g_7.graphite.rendering.entity;

import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.type.RenderClass;

public class EntityRenderClass extends RenderClass<IEntity, EntityRenderer>{

	public EntityRenderClass() {
		super(new EntityRenderer(), "ENTITIES");
	}

	@Override
	public void update(float deltaMillis) {
		foreach((d)->d.update(deltaMillis));
	}
}
