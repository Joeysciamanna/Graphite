package ch.g_7.graphite.entity;

import ch.g_7.graphite.resource.NamedKey;

public class EntityKey extends NamedKey {

    public static final String NAME = "ENTITY";

    public EntityKey(String name) {
        super(name);
    }

    @Override
    public String getResourceName() {
        return NAME;
    }
}
