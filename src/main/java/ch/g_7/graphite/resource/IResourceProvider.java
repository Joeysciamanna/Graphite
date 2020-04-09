package ch.g_7.graphite.resource;

import ch.g_7.util.io.IFileLoader;
import ch.g_7.util.io.IResourceLoader;

public interface IResourceProvider<T extends IResource, K extends IResourceKey> {

    boolean canProvide(IResourceKey resourceKey);

    T allocate(K resourceKey, IResourceLoader fileLoader);

    void closeResources();
    
    int getAllocations();
    
    int getRequests();

    IResourceProvider<T, K> newInstance();
}
