package ch.g_7.graphite.resource;

import java.util.*;

public class ResourcePool<T extends  IResource, K extends IResourceKey>{

    private Map<K, T> resources;

    public ResourcePool() {
        this.resources = new HashMap<>();
    }

    public void add(T resource, K resourceKey){
        if(resources.containsKey(resourceKey)){
            throw new IllegalArgumentException("Resource ["+resourceKey+"] already exists");
        }
        resources.put(resourceKey, resource);
    }

    public Optional<T> get(K resourceKey) {
        return Optional.ofNullable(resources.get(resourceKey));
    }

    public void closeAll(){
        for (T value : resources.values()) {
            value.close();
        }
        resources.clear();
    }
}
