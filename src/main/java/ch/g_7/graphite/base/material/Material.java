package ch.g_7.graphite.base.material;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.resource.IResource;
import ch.g_7.graphite.util.Color;

public class Material implements IMaterial, IResource {

	private final String name;
    private final Color color;
    private final Optional<ITexture> texture;
    private final VBO[] vbos;

    public Material(String name, Color color, ITexture texture) {
    	this.name = name;
        this.color = color;
        this.texture = Optional.ofNullable(texture);
        this.vbos = genListOfNullables(()->texture.getTextureCoordinatesVBO());
    }

    
    @Override
    public String getName() {
    	return name;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Optional<ITexture> getTexture() {
        return texture;
    }

    @Override
    public void close() { }

    @Override
    public void init() { }

    @Override
    public VBO[] getVBOs() {
        return vbos;
    }

    @SafeVarargs
    private final static <T> T[] genListOfNullables(Supplier<T>... suppliers){
        List<T> ts = new ArrayList<>();
        for (Supplier<T> supplier : suppliers) {
            try {
                ts.add(supplier.get());
            }catch (NullPointerException e){ }
        }
        T[] array = (T[]) new Object[ts.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = ts.get(i);
        }
        return array;
    }


}
