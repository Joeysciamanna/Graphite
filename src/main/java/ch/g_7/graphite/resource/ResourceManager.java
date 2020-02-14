package ch.g_7.graphite.resource;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager {

    public final static IFileLoader ENGINE_FILE_LOADER = new LocalFileLoader(){};
    private final static List<IResource> GLOBAL_RESOURCES = new ArrayList<>();
    private final static ResourceManager INSTANCE = new ResourceManager();


    private List<IResourceProvider> resourceLoaders;

    private ResourceManager() {
        this.resourceLoaders = new ArrayList<>();
    }

    public static ResourceManager getInstance() {
        return INSTANCE;
    }

    public <T> T getResource(String name) {
        for (IResourceProvider resourceLoader : resourceLoaders) {
            if (resourceLoader.canProvide(name)) {
                return (T) resourceLoader.get(name);
            }
        }
        throw new IllegalArgumentException("No resource with name ["+name+"] found");
    }


    public void addResourceLoader(IResourceProvider resourceLoader){
        this.resourceLoaders.add(resourceLoader);
    }


    public static <T extends IResource> T allocateGlobal(T resource){
        GLOBAL_RESOURCES.add(resource);
        resource.onAllocate();
        return resource;
    }

    public static void  unloadAll(){
        GLOBAL_RESOURCES.forEach((r)->r.onExtinguish());
        GLOBAL_RESOURCES.clear();
    }


}
