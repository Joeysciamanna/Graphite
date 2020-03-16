package ch.g_7.graphite.base.texture;

import ch.g_7.graphite.resource.NamedKey;

public class TextureKey extends NamedKey {

    public final static String NAME = "TEXTURE";

    public TextureKey(String path) {
        super(path);
    }

    @Override
    public String getResourceName() {
        return NAME;
    }
    
    

}
