package ch.g_7.graphite.resource;


import java.util.Optional;

public abstract class BasicResourceProvider<T extends IResource> implements IResourceProvider<T> {


    private ResourcePool<T> resourcePool;

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
        res.allocate();
        return res;
    }

    protected abstract T loadResource(String resourceName) throws IllegalArgumentException;

}
