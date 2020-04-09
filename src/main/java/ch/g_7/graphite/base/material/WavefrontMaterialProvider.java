package ch.g_7.graphite.base.material;

import java.io.InputStream;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.util.io.IFileLoader;
import ch.g_7.util.io.IResourceLoader;

@Deprecated
public class WavefrontMaterialProvider extends BasicResourceProvider<Material, MaterialKey> {


    @Override
    protected Material loadResource(MaterialKey resourceKey, IResourceLoader resourceLoader) throws IllegalArgumentException {
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

