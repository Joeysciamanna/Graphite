package ch.g_7.graphite.base.texture;

import ch.g_7.graphite.resource.NamedKey;
import ch.g_7.graphite.util.Util;

public class ImageKey extends NamedKey {

    public final static String NAME = "IMAGE";

    public ImageKey(String path) {
        super(path);
    }

    @Override
    public String getResourceName() {
        return NAME;
    }
    
    @Override
    public boolean equals(Object obj) {
    	return Util.isEqual(this, obj, ImageKey::getName);
    }
    
    

}
