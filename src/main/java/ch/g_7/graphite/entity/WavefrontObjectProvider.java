package ch.g_7.graphite.entity;

import ch.g_7.graphite.parse.wavefront.ObjectParser;
import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.util.io.IResourceLoader;

import java.io.InputStream;

public class WavefrontObjectProvider extends BasicResourceProvider<GameObject, EntityKey> {


    @Override
    protected GameObject loadResource(EntityKey resourceKey, IResourceLoader resourceLoader) {
        InputStream stream = resourceLoader.loadResourceThrowRuntime(resourceKey.getName());
        ObjectParser parser = new ObjectParser(stream);
        parser.parse();
        return parser.getEntity();
    }

    @Override
    public boolean canProvide(IResourceKey resourceKey) {
        return containsResourceNames(resourceKey, EntityKey.NAME);
    }

    @Override
    public IResourceProvider<GameObject, EntityKey> newInstance() {
        return new WavefrontObjectProvider();
    }





}
