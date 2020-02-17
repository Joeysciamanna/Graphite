package ch.g_7.graphite.resource;


import java.util.Optional;

public abstract class BasicResourceProvider<T extends IResource, K extends IResourceKey> implements IResourceProvider<T, K> {


    protected final ResourcePool<T, K> resourcePool;

    public BasicResourceProvider() {
        this.resourcePool = new ResourcePool<>();
    }

    @Override
    public T get(K resourceKey) {
        Optional<T> resource = resourcePool.get(resourceKey);
        if(resource.isPresent()){
            return resource.get();
        }
        T res = loadResource(resourceKey);
        resourcePool.add(res, resourceKey);
        res.init();
        return res;
    }

    protected abstract T loadResource(K resourceKey) throws IllegalArgumentException;

    @Override
    public void closeResources() {
        resourcePool.closeAll();
    }

}
