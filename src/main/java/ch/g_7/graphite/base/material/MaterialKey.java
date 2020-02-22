package ch.g_7.graphite.base.material;

import ch.g_7.graphite.resource.NamedKey;
import ch.g_7.util.helper.Util;

public class MaterialKey extends NamedKey {

    public final static String NAME = "MATERIAL";

    public MaterialKey(String path) {
        super(path);
    }

    @Override
    public String getResourceName() {
        return NAME;
    }
    
    @Override
    public boolean equals(Object obj) {
    	return Util.isEqual(this, obj, MaterialKey::getName);
    }
}
