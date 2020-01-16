package ch.g_7.graphite.rendering.entity;

import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.RenderCluster;

public class EntityRenderCluster extends RenderCluster<IEntity, EntityRenderer>{

	public EntityRenderCluster() {
		super(new EntityRenderer(), "ENTITIES");
	}

	@Override
	public void update(float deltaMillis) {
		foreach((d)->d.update(deltaMillis));
	}
}
