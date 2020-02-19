package ch.g_7.graphite.resource;


import java.util.Optional;

public abstract class BasicResourceProvider<T extends IResource, K extends IResourceKey> implements IResourceProvider<T, K> {


    protected final ResourcePool<T, K> resourcePool;
    private int allocations;
    private int requests;
    
    public BasicResourceProvider() {
        this.resourcePool = new ResourcePool<>();
    }

    @Override
    public T get(K resourceKey) {
        Optional<T> resource = resourcePool.get(resourceKey);
        requests++;
        if(resource.isPresent()){
            return resource.get();
        }
        allocations++;
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
    
    @Override
    public int getAllocations() {
    	return allocations;
    }
    
    @Override
    public int getRequests() {
    	return requests;
    }

}
