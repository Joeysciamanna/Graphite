package ch.g_7.graphite.resource;


import ch.g_7.util.io.IResourceLoader;

import java.util.Optional;

public abstract class BasicResourceProvider<T extends IResource, K extends IResourceKey> implements IResourceProvider<T, K> {


    protected final ResourcePool<T, K> resourcePool;
    private int allocations;
    private int requests;
    
    public BasicResourceProvider() {
        this.resourcePool = new ResourcePool<>();
    }

    @Override
    public T allocate(K resourceKey, IResourceLoader fileLoader) {
        Optional<T> resource = resourcePool.get(resourceKey);
        requests++;
        if(resource.isPresent()){
            return resource.get();
        }
        allocations++;
        T res = loadResource(resourceKey, fileLoader);
        resourcePool.add(res, resourceKey);
        res.init();
        return res;
    }

    protected abstract T loadResource(K resourceKey, IResourceLoader resourceLoader);

    protected static void checkResourceNames(IResourceKey resourceKey, String... names){
        if(!containsResourceNames(resourceKey, names))
            throw new IllegalArgumentException("Provider can not provide Resource ["+resourceKey.getResourceName()+"]");
    }

    protected static boolean containsResourceNames(IResourceKey resourceKey, String... names){
        for (String name : names) {
            if(name.equals(resourceKey.getResourceName())) return true;
        }
        return false;
    }

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
