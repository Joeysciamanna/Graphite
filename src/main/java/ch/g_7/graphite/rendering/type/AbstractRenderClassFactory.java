package ch.g_7.graphite.rendering.type;

public abstract class AbstractRenderClassFactory<T extends Enum<T> & IRenderType<T>> {

	@SuppressWarnings("unchecked")
	protected final RenderClass<?, ?> getRenderClass(IRenderType<? extends IRenderType<?>> renderType){
		return produceRenderClass((T) renderType);
	}
	
	protected abstract RenderClass<?, ?> produceRenderClass(T renderType);
	
	public abstract boolean produces(@SuppressWarnings("rawtypes") Class<? extends IRenderType> renderTypeFamiliy);
}
