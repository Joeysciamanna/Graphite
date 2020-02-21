package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IFileLoader;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;

public class ViewModelProvider extends BasicResourceProvider<ViewModel, IViewModelKey> {


    @Override
    protected ViewModel loadResource(IViewModelKey resourceKey, IFileLoader fileLoader) throws IllegalArgumentException {
        return null;
    }

    @Override
    public boolean canProvide(IResourceKey resourceKey) {
        return false;
    }

    @Override
    public IResourceProvider<ViewModel, IViewModelKey> newInstance() {
        return null;
    }
}
