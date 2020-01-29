package ch.g_7.graphite.rendering.type;

import ch.g_7.graphite.rendering.draw.DrawRenderClass;
import ch.g_7.graphite.rendering.entity.EntityRenderClass;
import ch.g_7.graphite.rendering.ui.UIRenderClass;

public class DefaultRenderClassFactory extends AbstractRenderClassFactory<DefaultRenderType> {

	@Override
	protected RenderClass<?, ?> produceRenderClass(DefaultRenderType renderType) {
		switch (renderType) {
		case UI:
			return new UIRenderClass(); 
		case ENTITIES:
			return new EntityRenderClass();
		case DRAWABLE:
			return new DrawRenderClass();
		default:
			throw new IllegalArgumentException("Unexpected value: " + renderType);
		}
	}

	


	@Override
	public boolean produces(@SuppressWarnings("rawtypes") Class<? extends IRenderType> renderTypeFamiliy) {
		return DefaultRenderType.class.equals(renderTypeFamiliy);
	}

	

}
