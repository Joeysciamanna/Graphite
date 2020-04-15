package ch.g_7.graphite.node;

import ch.g_7.util.bitkey.BitKey;
import ch.g_7.util.bitkey.BitKeyBuilder;
import ch.g_7.util.common.IIdentifier;

import java.util.HashMap;
import java.util.Map;

public class NodeAbilityProvider {

    private static final NodeAbilityProvider instance = new NodeAbilityProvider();

    private final BitKeyBuilder bitKeyBuilder;
    private final Map<String, Integer> abilities;

    public NodeAbilityProvider() {
        this.bitKeyBuilder = new BitKeyBuilder();
        this.abilities = new HashMap<>();
    }

    public int next(String name){
        if(abilities.containsKey(name)) throw new IllegalArgumentException("Ability ["+name+"] already registered");

        bitKeyBuilder.next();
        int value = bitKeyBuilder.getInt();
        abilities.put(name, value);
        return value;
    }

    public String getAbilities(int key){
        StringBuilder abilitiesString = new StringBuilder();
        for (Map.Entry<String, Integer> entry : abilities.entrySet()) {
            if((entry.getValue() & key) != 0){
                abilitiesString.append(entry.getKey()).append(", ");
            }
        }
        return abilitiesString.toString();
    }

    public static NodeAbilityProvider getInstance() {
        return instance;
    }

}
