package ch.g_7.graphite.resource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import ch.g_7.graphite.base.material.WavefrontMaterialProvider;
import ch.g_7.graphite.base.mesh.MeshProvider;
import ch.g_7.graphite.base.texture.TextureProvider;
import ch.g_7.graphite.entity.WavefrontObjectProvider;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.helper.Util;
import ch.g_7.util.io.IFileLoader;
import ch.g_7.util.io.LocalFileLoader;

public class ResourceManager implements Closeable {

	public final static IFileLoader ENGINE_FILE_LOADER = new LocalFileLoader() {};
	public static IFileLoader GAME_FILE_LOADER;
	
	
	
	private final static List<Closeable> GLOBAL_RESOURCES = new ArrayList<>();
	private static final LinkedList<ResourceManager> STACK = new LinkedList<>();
	private static ResourceManager ACTIVE = new ResourceManager();

	static {
		ACTIVE.addResourceLoader(new WavefrontObjectProvider());
		ACTIVE.addResourceLoader(new TextureProvider());
		ACTIVE.addResourceLoader(new MeshProvider());
	}

	private List<IResourceProvider<?, ?>> resourceProviders;

	private ResourceManager() {
		this.resourceProviders = new ArrayList<>();
	}

	public <T extends IResource, K extends IResourceKey> T allocateFromEngine(K resourceKey) {
		return allocate(resourceKey, ENGINE_FILE_LOADER);
	}

	public <T extends IResource, K extends IResourceKey> T allocateFromGame(K resourceKey) {
		if(GAME_FILE_LOADER == null) throw new IllegalStateException("GameFileLoader not set");
		return allocate(resourceKey, GAME_FILE_LOADER);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends IResource, K extends IResourceKey> T allocate(K resourceKey, IFileLoader fileLoader) {
		for (IResourceProvider<?, ?> resourceLoader : resourceProviders) {
			if (resourceLoader.canProvide(resourceKey)) {
				return (T) resourceLoader.allocate(Util.cast(resourceKey), fileLoader);
			}
		}
		throw new IllegalArgumentException("No resource with key [" + resourceKey + "] found");
	}
	

	public void addResourceLoader(IResourceProvider<?, ?> resourceLoader) {
		this.resourceProviders.add(resourceLoader);
	}

	@SuppressWarnings("unchecked")
	public <T extends IResourceProvider<?,?>> Optional<T> getResourceProvider(Class<T> type) {
		for (IResourceProvider<?,?> resourceProvider : resourceProviders) {
			if(type.isAssignableFrom(resourceProvider.getClass())) {
				return Optional.of((T) resourceProvider);
			}
		}
		return Optional.empty();
	}
	
	
	public int getAllocations() {
		int i = 0;
		for (IResourceProvider<?,?> resourceProvider : resourceProviders) {
			i+=resourceProvider.getAllocations();
		}
		return i;
	}
	
	public int getRequests() {
		int i = 0;
		for (IResourceProvider<?,?> resourceProvider : resourceProviders) {
			i+=resourceProvider.getRequests();
		}
		return i;
	}
	
	@Override
	public void close() {
		for (IResourceProvider<?, ?> resourceProvider : resourceProviders) {
			resourceProvider.closeResources();
		}
		resourceProviders.clear();
	}

	public static void closeAll() {
		closeGlobals();
		ACTIVE.close();
		for (ResourceManager resourceManager : STACK) {
			resourceManager.close();
		}
		STACK.clear();
	}

	public static void closeGlobals() {
		GLOBAL_RESOURCES.forEach((r) -> r.close());
		GLOBAL_RESOURCES.clear();
	}

	public static void pushToStack() {
		ResourceManager newManager = new ResourceManager();
		for (IResourceProvider<?, ?> resourceProvider : ACTIVE.resourceProviders) {
			newManager.addResourceLoader(resourceProvider.newInstance());
		}
		STACK.addFirst(ACTIVE);
		ACTIVE = newManager;
	}

	public static void pullFromStack() {
		ACTIVE.close();
		ACTIVE = STACK.poll();
	}

	public static <T extends Closeable> T addGlobalClosable(T resource) {
		GLOBAL_RESOURCES.add(resource);
		return resource;
	}

	public static <T extends IResource> T addGlobalResource(T resource) {
		GLOBAL_RESOURCES.add(resource);
		resource.init();
		return resource;
	}
	
	public static int getTotalAllocations() {
		int i = ACTIVE.getAllocations() + GLOBAL_RESOURCES.size();
		for (ResourceManager resourceManager : STACK) {
			i+=resourceManager.getAllocations();
		}
		return i;
	}
	
	public static int getTotalRequests() {
		int i = ACTIVE.getRequests() + GLOBAL_RESOURCES.size();
		for (ResourceManager resourceManager : STACK) {
			i+=resourceManager.getRequests();
		}
		return i;
	}
	
	public static ResourceManager getActive() {
		return ACTIVE;
	}

	public static void setGameFileLoader(IFileLoader gameFileLoader) {
		if(gameFileLoader != null) throw new IllegalStateException("GameFileLoader already set");
		GAME_FILE_LOADER = gameFileLoader;
	}
}
