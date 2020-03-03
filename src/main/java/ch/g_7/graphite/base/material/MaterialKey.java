package ch.g_7.graphite.base.material;

import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.util.helper.Util;

/**
 * Patter: filepath:MaterialName
 */
public class MaterialKey implements IResourceKey {

    public final static String NAME = "MATERIAL";

    private String path;
    private String name;

    public MaterialKey(String path) {
        this.path = path.substring(0, path.lastIndexOf(":"));
        this.name = path.substring(path.lastIndexOf(":"));
    }

    @Override
    public boolean equals(Object obj) {
        return  Util.isEqual(this, obj, MaterialKey::getName, MaterialKey::getPath, MaterialKey::getResourceName);
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String getResourceName() {
        return NAME;
    }
    
}
