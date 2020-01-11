package ch.g_7.graphite.util;

import java.util.HashMap;
import java.util.Map;

import ch.g_7.util.task.SecureRunner;

public class ResourceHandler {
	
	private Map<IResource, Counter> resources;
	private SecureRunner<IResource, Void> resourceCloser;
	
	private final static ResourceHandler instance = new ResourceHandler();
	
	public ResourceHandler() {
		this.resources = new HashMap<>();
		this.resourceCloser = new SecureRunner<IResource, Void>((r)->{r.close(); return null;});
	}
	
	public void init(IResource resource) {
		if(!resources.containsKey(resource)) {
			resource.init();
			resources.put(resource, new Counter().increase());
		}else {
			resources.get(resource).increase();
		}
	}
	
	public void close(IResource resource) {
		if(!resources.containsKey(resource)) {
			throw new IllegalStateException("Resource " + resource + " was never registerd/initialized");
		} else {
			Counter c = resources.get(resource);
			c.decrease();
			if(c.getValue() == 0) {
				resourceCloser.close(resource);
			}
		}
	}
	
	public static ResourceHandler getInstance() {
		return instance;
	}
	
	
	
}
