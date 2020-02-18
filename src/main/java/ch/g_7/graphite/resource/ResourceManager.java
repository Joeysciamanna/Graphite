package ch.g_7.graphite.resource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ch.g_7.graphite.base.material.MaterialProducer;
import ch.g_7.graphite.base.mesh.MeshProvider;
import ch.g_7.graphite.base.texture.TextureProvider;
import ch.g_7.util.common.Closeable;

public class ResourceManager implements Closeable {

    public final static IFileLoader ENGINE_FILE_LOADER = new LocalFileLoader(){};
    private final static List<Closeable> GLOBAL_RESOURCES = new ArrayList<>();
    private static final LinkedList<ResourceManager> STACK = new LinkedList<>();
    private static ResourceManager ACTIVE = new ResourceManager();

    static {
    	ACTIVE.addResourceLoader(new MaterialProducer(ENGINE_FILE_LOADER));
    	ACTIVE.addResourceLoader(new TextureProvider(ENGINE_FILE_LOADER));
    	ACTIVE.addResourceLoader(new MeshProvider());
    }

    private List<IResourceProvider<?,?>> resourceProviders;

    private ResourceManager() {
        this.resourceProviders = new ArrayList<>();
    }

    public static ResourceManager getActive() {
        return ACTIVE;
    }

    @SuppressWarnings("unchecked")
	public <T extends IResource, K extends IResourceKey> T getResource(K resourceKey) {
        for (IResourceProvider<?, ?> resourceLoader : resourceProviders) {
            if (resourceLoader.canProvide(resourceKey)) {
                return (T) resourceLoader.get(cast(resourceKey));
            }
        }
        throw new IllegalArgumentException("No resource with key ["+resourceKey+"] found");
    }

    @SuppressWarnings("unchecked")
	private <T> T cast(Object object) {
    	return (T) object;
    }
    
    public void addResourceLoader(IResourceProvider<?,?> resourceLoader){
        this.resourceProviders.add(resourceLoader);
    }

    public static void pushToStack(){
        ResourceManager newManager = new ResourceManager();
        for (IResourceProvider<?,?> resourceProvider : ACTIVE.resourceProviders) {
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
        for (IResourceProvider<?,?> resourceProvider : resourceProviders) {
            resourceProvider.closeResources();
        }
        resourceProviders.clear();
    }


    public static <T extends Closeable> T addGlobalClosable(T resource){
        GLOBAL_RESOURCES.add(resource);
        return resource;
    }

    public static <T extends IResource> T addGlobalResource(T resource){
        GLOBAL_RESOURCES.add(resource);
        resource.init();
        return resource;
    }
    
    public static void closeAll() {
    	closeGlobals();
    	ACTIVE.close();
    	for (ResourceManager resourceManager : STACK) {
			resourceManager.close();
		}
    	STACK.clear();
    }

    public static void closeGlobals(){
        GLOBAL_RESOURCES.forEach((r)->r.close());
        GLOBAL_RESOURCES.clear();
    }


}
