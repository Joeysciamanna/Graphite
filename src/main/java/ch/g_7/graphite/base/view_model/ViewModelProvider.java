package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.util.io.IFileLoader;

public class ViewModelProvider extends BasicResourceProvider<ViewModel, ViewModelKey> {


    @Override
    protected ViewModel loadResource(ViewModelKey resourceKey, IFileLoader fileLoader) throws IllegalArgumentException {














        return null;
    }

    @Override
    public boolean canProvide(IResourceKey resourceKey) {
        return containsResourceNames(resourceKey, ViewModelKey.NAME);
    }

    @Override
    public IResourceProvider<ViewModel, ViewModelKey> newInstance() {
        return null;
    }
}
