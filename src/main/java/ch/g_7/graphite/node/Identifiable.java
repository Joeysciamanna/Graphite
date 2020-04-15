package ch.g_7.graphite.node;

public interface Identifiable {

    int ABILITY = NodeAbilityProvider.getInstance().next("identifiable");

    IEntityId getId();

}
