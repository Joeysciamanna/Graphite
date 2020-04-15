package ch.g_7.graphite.node;

public interface Updatable {

	int ABILITY = NodeAbilityProvider.getInstance().next("updatable");
 
	void update(float deltaMillis);
	
}
