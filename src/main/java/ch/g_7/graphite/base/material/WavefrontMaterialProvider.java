package ch.g_7.graphite.base.material;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.util.io.IFileLoader;

import java.io.InputStream;

@Deprecated
public class WavefrontMaterialProvider extends BasicResourceProvider<Material, MaterialKey> {


    @Override
    protected Material loadResource(MaterialKey resourceKey, IFileLoader fileLoader) throws IllegalArgumentException {
        return null;
    }

    public void loadAll(InputStream inputStream) { }
    
    @Override
    public boolean canProvide(IResourceKey resourceKey) {
        return resourceKey.getResourceName().equals(MaterialKey.NAME);
    }

    @Override
    public IResourceProvider<Material, MaterialKey> newInstance() {
        return new WavefrontMaterialProvider();
    }
}

