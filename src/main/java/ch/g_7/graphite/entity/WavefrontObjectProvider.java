package ch.g_7.graphite.entity;

import java.io.InputStream;

import ch.g_7.graphite.parse.wavefront.ObjectParser;
import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.util.io.IFileLoader;

public class WavefrontObjectProvider extends BasicResourceProvider<GameObject, EntityKey> {


    @Override
    protected GameObject loadResource(EntityKey resourceKey, IFileLoader fileLoader) throws IllegalArgumentException {
        InputStream stream = fileLoader.loadFile(resourceKey.getName());
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
