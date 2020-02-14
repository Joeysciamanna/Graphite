package ch.g_7.graphite.resource;

public interface IResourceProvider<T extends IResource> {

    boolean canProvide(String resourceName);

    T get(String resourceName);
}
