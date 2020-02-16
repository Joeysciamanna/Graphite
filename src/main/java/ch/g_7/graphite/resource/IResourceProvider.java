package ch.g_7.graphite.resource;

public interface IResourceProvider<T extends IResource> {

    boolean canProvide(String resourceName);

    String getKey();

    T get(String resourceName);

    void closeResources();

    IResourceProvider<T> newInstance();
}
