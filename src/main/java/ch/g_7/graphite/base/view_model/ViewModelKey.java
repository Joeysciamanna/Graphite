package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.resource.NamedKey;

public class ViewModelKey extends NamedKey {

    public static final String NAME = "VIEW_MODEL";

    public ViewModelKey(String path) {
        super(path);
    }

    @Override
    public String getResourceName() {
        return NAME;
    }
}
