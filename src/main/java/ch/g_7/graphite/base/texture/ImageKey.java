package ch.g_7.graphite.base.texture;

import ch.g_7.graphite.resource.NamedKey;

public class ImageKey extends NamedKey {

    public final static String NAME = "IMAGE";

    public ImageKey(String path) {
        super(path);
    }

    @Override
    public String getResourceName() {
        return NAME;
    }
}
