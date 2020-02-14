package ch.g_7.graphite.resource;

import java.util.*;

public class ResourcePool<T extends  IResource>{

    private Map<String, T> resources;

    public ResourcePool() {
        this.resources = new HashMap<>();
    }

    public void add(T resource, String name){
        resources.put(name, resource);
    }

    public Optional<T> get(String resourceName) {
        return Optional.ofNullable(resources.get(resourceName));
    }

    public void unloadAll(){
        for (T value : resources.values()) {
            value.onExtinguish();
        }
        resources.clear();
    }
}
