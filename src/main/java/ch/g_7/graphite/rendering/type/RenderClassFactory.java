package ch.g_7.graphite.rendering.type;

import java.util.ArrayList;
import java.util.List;

public class RenderClassFactory {

	private static final List<AbstractRenderClassFactory<?>> renderClassFactorys = new ArrayList<>();;
	
	static {
		renderClassFactorys.add(new DefaultRenderClassFactory());
	}
	
	
	public static RenderClass<?, ?> getRenderClass(IRenderType<?> renderType) {
		for (AbstractRenderClassFactory<?> renderClassFactory : renderClassFactorys) {
			if(renderClassFactory.produces(renderType.getClass())) {
				return renderClassFactory.getRenderClass(renderType);
			}
		}
		throw new IllegalArgumentException("No RenderClass for type " + renderType + " found.");
	}
	
	public void register(AbstractRenderClassFactory<?> factory) {
		for (AbstractRenderClassFactory<?> f : renderClassFactorys) {
			if(f.getClass().equals(factory.getClass())) {
				throw new IllegalArgumentException("RenderClass alredy registerd");
			}
		}
		renderClassFactorys.add(factory);
	}
	
	public void remove(Class<? extends AbstractRenderClassFactory<?>> factoryClass) {
		renderClassFactorys.removeIf((f) -> f.getClass().equals(factoryClass));
	}

	
}
