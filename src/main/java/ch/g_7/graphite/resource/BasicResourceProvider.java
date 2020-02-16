package ch.g_7.graphite.resource;


import java.util.Optional;

public abstract class BasicResourceProvider<T extends IResource> implements IResourceProvider<T> {


    protected final ResourcePool<T> resourcePool;

    public BasicResourceProvider() {
        this.resourcePool = new ResourcePool<>();
    }

    @Override
    public T get(String resourceName) {
        Optional<T> resource = resourcePool.get(resourceName);
        if(resource.isPresent()){
            return resource.get();
        }
        T res = loadResource(resourceName);
        resourcePool.add(res, resourceName);
        res.init();
        return res;
    }

    protected abstract T loadResource(String resourceName) throws IllegalArgumentException;

    @Override
    public void closeResources() {
        resourcePool.closeAll();
    }

    @Deprecated
    public void register(T resource, String name){
        resourcePool.add(resource, name);
    }
}
