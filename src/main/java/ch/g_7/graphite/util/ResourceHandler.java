package ch.g_7.graphite.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class ResourceHandler {

	private final static Map<Object, Counter> resources = new HashMap<>();;

	private ResourceHandler() {}

	public static boolean shallInitialize(Object object) {
		if (resources.containsKey(object)) {
			resources.get(object).increase();
			return false;
		} else {
			resources.put(object, new Counter().increase());
			return true;
		}

	}

	public static boolean shallClose(Object object) {
		if (!resources.containsKey(object)) {
			throw new IllegalStateException("Resource " + object + " was never registerd/initialized or has alredy been cloesed");
		} else {
			if (resources.get(object).decrease().getValue() == 0) {
				resources.remove(object);
				return true;
			}
			return false;
		}
	}

	public static boolean hasUnclosedResources() {
		return !resources.isEmpty();
	}

	public static String getUnclosedResourcesTable() {
		StringBuilder stringBuilder = new StringBuilder("Unclosed Resources:\n");
		for (Entry<Object, Counter> entry : resources.entrySet()) {
			stringBuilder.append(entry.getValue().getValue() + "x\t" + entry.getKey().getClass().getSimpleName() + "\n");
		}
		return stringBuilder.toString();
	}
	
	@Deprecated
	public static void closeAll() {
		resources.forEach((r, c) -> {
			if (resources instanceof AutoCloseable) {
				try {
					((AutoCloseable) resources).close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}

}
