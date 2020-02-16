package ch.g_7.graphite.resource;

import ch.g_7.util.common.Closeable;

import java.util.*;

public class ResourceManager implements Closeable {

    public final static IFileLoader ENGINE_FILE_LOADER = new LocalFileLoader(){};
    private final static List<IResource> GLOBAL_RESOURCES = new ArrayList<>();
    private static final LinkedList<ResourceManager> STACK = new LinkedList<>();
    private static ResourceManager ACTIVE = new ResourceManager();


    private List<IResourceProvider> resourceProviders;

    private ResourceManager() {
        this.resourceProviders = new ArrayList<>();
    }

    public static ResourceManager getActive() {
        return ACTIVE;
    }

    public <T extends IResource, K extends IResourceKey> T getResource(K resourceKey) {
        for (IResourceProvider resourceLoader : resourceProviders) {
            if (resourceLoader.canProvide(resourceKey)) {
                return (T) resourceLoader.get(resourceKey);
            }
        }
        throw new IllegalArgumentException("No resource with key ["+resourceKey+"] found");
    }

    public <T extends IResourceProvider> T getResourceProvdier(String name, Class<T> type){
        for (IResourceProvider resourceProvider : resourceProviders) {
            if(resourceProvider.getName().equals(name)){
                return type.cast(resourceProvider);
            }
        }
        throw new IllegalArgumentException("No ResourceProvider with name ["+name+"] found");
    }

    public void addResourceLoader(IResourceProvider resourceLoader){
        this.resourceProviders.add(resourceLoader);
    }

    public static void pushToStack(){
        ResourceManager newManager = new ResourceManager();
        for (IResourceProvider resourceProvider : ACTIVE.resourceProviders) {
            newManager.addResourceLoader(resourceProvider.newInstance());
        }
        STACK.addFirst(ACTIVE);
        ACTIVE = newManager;
    }

    public static void pullFromStack(){
        ACTIVE.close();
        ACTIVE = STACK.poll();
    }

    @Override
    public void close(){
        for (IResourceProvider resourceProvider : resourceProviders) {
            resourceProvider.closeResources();
        }
        resourceProviders.clear();
    }


    public static <T extends IResource> T allocateGlobal(T resource){
        GLOBAL_RESOURCES.add(resource);
        resource.init();
        return resource;
    }

    private static void closeGlobals(){
        GLOBAL_RESOURCES.forEach((r)->r.close());
        GLOBAL_RESOURCES.clear();
    }


}
