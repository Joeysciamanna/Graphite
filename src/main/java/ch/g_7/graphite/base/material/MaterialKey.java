package ch.g_7.graphite.base.material;

import ch.g_7.graphite.resource.IResourceKey;
import ch.g_7.graphite.resource.NamedKey;

public class MaterialKey extends NamedKey {

    public final static String NAME = "MATERIAL";

    public MaterialKey(String path) {
        super(path);
    }

    @Override
    public String getResourceName() {
        return NAME;
    }
}
