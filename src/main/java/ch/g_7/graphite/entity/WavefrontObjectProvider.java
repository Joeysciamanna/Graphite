package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.material.Material;
import ch.g_7.graphite.base.material.MaterialKey;
import ch.g_7.graphite.math.vec2.Vector2f;
import ch.g_7.graphite.math.vec3.Vector3f;
import ch.g_7.graphite.resource.BasicResourceProvider;
import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.IResourceProvider;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.util.io.IFileLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class WavefrontObjectProvider extends BasicResourceProvider<Entity, EntityKey> {


    @Override
    protected Entity loadResource(EntityKey resourceKey, IFileLoader fileLoader) throws IllegalArgumentException {
        InputStream stream = fileLoader.loadFile(resourceKey.getName());
        WavefrontObjectParser parser = new WavefrontObjectParser(stream);
        parser.parse();
    }

    @Override
    public boolean canProvide(IResourceKey resourceKey) {
        return containsResourceNames(resourceKey, EntityKey.NAME);
    }

    @Override
    public IResourceProvider<Entity, EntityKey> newInstance() {
        return new WavefrontObjectProvider();
    }





}
